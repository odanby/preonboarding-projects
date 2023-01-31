package com.tabitha.api;

import com.tabitha.controllers.CalendarController;
import com.tabitha.controllers.CategoryController;
import com.tabitha.controllers.NotebookController;
import com.tabitha.controllers.TaskListController;
import com.tabitha.controllers.UserController;
import com.tabitha.repository.CalendarDAO;
import com.tabitha.repository.CalendarDAOInterface;
import com.tabitha.repository.CategoryDAO;
import com.tabitha.repository.CategoryDAOInterface;
import com.tabitha.repository.NotebookDAO;
import com.tabitha.repository.NotebookDAOInterface;
import com.tabitha.repository.TaskListDAO;
import com.tabitha.repository.TaskListDAOInterface;
import com.tabitha.repository.UserDAO;
import com.tabitha.repository.UserDAOInterface;
import com.tabitha.service.CalendarService;
import com.tabitha.service.CalendarServiceInterface;
import com.tabitha.service.CategoryService;
import com.tabitha.service.CategoryServiceInterface;
import com.tabitha.service.NotebookService;
import com.tabitha.service.NotebookServiceInterface;
import com.tabitha.service.TaskListService;
import com.tabitha.service.TaskListServiceInterface;
import com.tabitha.service.UserService;
import com.tabitha.service.UserServiceInterface;
import com.tabitha.utils.CalendarBusinessRules;
import com.tabitha.utils.CategoryBusinessRules;
import com.tabitha.utils.HibernateUtil;
import com.tabitha.utils.NotebookBusinessRules;
import com.tabitha.utils.TaskListBusinessRules;
import com.tabitha.utils.UserBusinessRules;

import io.javalin.Javalin;

public class Main {

    public static void main(String[] args){
        HibernateUtil.getSessionFactory();

        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        // user
        UserDAOInterface userDao = new UserDAO();
        UserBusinessRules userBusinessRules = new UserBusinessRules();
        UserServiceInterface userService = new UserService(userDao, userBusinessRules);
        UserController userController = new UserController(userService);

        app.patch("/user/login", userController.loginUser);
        app.post("/user/new", userController.createNewAccount);
        app.get("/user/all", userController.getAllUsers);
        app.get("/user/{id}", userController.getUserById);
        app.patch("/user/update", userController.updateUser);

        // tasklist
        TaskListDAOInterface tasklistDao = new TaskListDAO();
        TaskListBusinessRules tasklistBusinessRules = new TaskListBusinessRules();
        TaskListServiceInterface tasklistService = new TaskListService(tasklistDao, tasklistBusinessRules);
        TaskListController tasklistController = new TaskListController(tasklistService);

        app.get("/tasklist/all", tasklistController.getAllTasks);
        app.get("/tasklist/{task_user_id}", tasklistController.getTaskByUserId);
        app.get("/tasklist/{task_id}", tasklistController.getTaskByTaskId);
        app.post("/tasklist/new", tasklistController.createTask);
        app.delete("/tasklist/{task_id}", tasklistController.removeTask);
        app.patch("/tasklist/{task_id}", tasklistController.updateTask);

        // category
        CategoryDAOInterface categoryDao = new CategoryDAO();
        CategoryBusinessRules categoryBusinessRules = new CategoryBusinessRules();
        CategoryServiceInterface categoryService = new CategoryService(categoryDao, categoryBusinessRules);
        CategoryController categoryController = new CategoryController(categoryService);

        app.get("/category/all", categoryController.getAllCategories);
        app.get("/category/{task_user_id}", categoryController.getCategoryByUserId);
        app.get("/category/{category_id}", categoryController.getCategoryByCategoryId);
        app.post("/category/new", categoryController.createCategory);
        app.delete("/category/{category_id}", categoryController.removeCategory);
        app.patch("/category/{category_id}", categoryController.updateCategory);

        // notebook
        NotebookDAOInterface notebookDao = new NotebookDAO();
        NotebookBusinessRules notebookBusinessRules = new NotebookBusinessRules();
        NotebookServiceInterface notebookService = new NotebookService(notebookDao, notebookBusinessRules);
        NotebookController notebookController = new NotebookController(notebookService);

        app.get("/notebook/all", notebookController.getAllNotebookEntries);
        app.get("/notebook/{task_user_id}", notebookController.getNotebookByUserId);
        app.get("/notebook/{notebook_id}", notebookController.getNotebookByNotebookId);
        app.post("/notebook/new", notebookController.createNotebookEntry);
        app.delete("/notebook/{notebook_id}", notebookController.removeNotebookEntry);
        app.patch("/notebook/{notebook_id}", notebookController.updateNotebookEntry);

        // calendar
        CalendarDAOInterface calendarDao = new CalendarDAO();
        CalendarBusinessRules calendarBusinessRules = new CalendarBusinessRules();
        CalendarServiceInterface calendarService = new CalendarService(calendarDao, calendarBusinessRules);
        CalendarController calendarController = new CalendarController(calendarService);

        app.get("/calendar/all", calendarController.getAllEvents);
        app.get("/calendar/{event_id}", calendarController.getEventByEventId);
        app.get("/calendar/{task_user_id}", calendarController.getEventByUserId);
        app.get("/calendar/{event_status}", calendarController.getEventByEventStatus);
        app.get("/calendar/{day_status}", calendarController.getEventByDayStatus);
        app.post("/calendar/new", calendarController.createEvent);
        app.delete("/calendar/{event_id}", calendarController.removeEvent);
        app.patch("/calendar/{event_id}", calendarController.updateEvent);

        app.start();
    }
}