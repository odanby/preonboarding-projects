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

        app.patch("/tabitha/user/login", userController.loginUser);
        app.post("/tabitha/user/new", userController.createNewAccount);
        app.get("/tabitha/user/all", userController.getAllUsers);
        app.get("/tabitha/user/{id}", userController.getUserById);
        app.get("/tabitha/user/username/{username}", userController.getUserByUsername);
        app.patch("/tabitha/user/update/{id}", userController.updateUser);

        // tasklist
        TaskListDAOInterface tasklistDao = new TaskListDAO();
        TaskListBusinessRules tasklistBusinessRules = new TaskListBusinessRules();
        TaskListServiceInterface tasklistService = new TaskListService(tasklistDao, tasklistBusinessRules);
        TaskListController tasklistController = new TaskListController(tasklistService);

        app.get("/tabitha/tasklist/all", tasklistController.getAllTasks);
        app.get("/tabitha/tasklist/user/{task_user_id}", tasklistController.getTaskByUserId);
        app.get("/tabitha/tasklist/task/{task_id}", tasklistController.getTaskByTaskId);
        app.get("/tabitha/tasklist/category/{category_id}", tasklistController.getTaskByCategoryId);
        app.post("/tabitha/tasklist/new", tasklistController.createTask);
        app.delete("/tabitha/tasklist/{task_id}", tasklistController.removeTask);
        app.patch("/tabitha/tasklist/{task_id}", tasklistController.updateTask);

        // category
        CategoryDAOInterface categoryDao = new CategoryDAO();
        CategoryBusinessRules categoryBusinessRules = new CategoryBusinessRules();
        CategoryServiceInterface categoryService = new CategoryService(categoryDao, categoryBusinessRules);
        CategoryController categoryController = new CategoryController(categoryService);

        app.get("/tabitha/category/all", categoryController.getAllCategories);
        app.get("/tabitha/category/{task_user_id}", categoryController.getCategoryByUserId);
        app.get("/tabitha/category/{category_id}", categoryController.getCategoryByCategoryId);
        app.post("/tabitha/category/new", categoryController.createCategory);
        app.delete("/tabitha/category/{category_id}", categoryController.removeCategory);
        app.patch("/tabitha/category/{category_id}", categoryController.updateCategory);

        // notebook
        NotebookDAOInterface notebookDao = new NotebookDAO();
        NotebookBusinessRules notebookBusinessRules = new NotebookBusinessRules();
        NotebookServiceInterface notebookService = new NotebookService(notebookDao, notebookBusinessRules);
        NotebookController notebookController = new NotebookController(notebookService);

        app.get("/tabitha/notebook/all", notebookController.getAllNotebookEntries);
        app.get("/tabitha/notebook/{task_user_id}", notebookController.getNotebookByUserId);
        app.get("/tabitha/notebook/{notebook_id}", notebookController.getNotebookByNotebookId);
        app.post("/tabitha/notebook/new", notebookController.createNotebookEntry);
        app.delete("/tabitha/notebook/{notebook_id}", notebookController.removeNotebookEntry);
        app.patch("/tabitha/notebook/{notebook_id}", notebookController.updateNotebookEntry);

        // calendar
        CalendarDAOInterface calendarDao = new CalendarDAO();
        CalendarBusinessRules calendarBusinessRules = new CalendarBusinessRules();
        CalendarServiceInterface calendarService = new CalendarService(calendarDao, calendarBusinessRules);
        CalendarController calendarController = new CalendarController(calendarService);

        app.get("/tabitha/calendar/all", calendarController.getAllEvents);
        app.get("/tabitha/calendar/{event_id}", calendarController.getEventByEventId);
        app.get("/tabitha/calendar/{task_user_id}", calendarController.getEventByUserId);
        app.get("/tabitha/calendar/event/{event_status}", calendarController.getEventByEventStatus);
        app.get("/tabitha/calendar/day/{day_status}", calendarController.getEventByDayStatus);
        app.post("/tabitha/calendar/new", calendarController.createEvent);
        app.delete("/tabitha/calendar/{event_id}", calendarController.removeEvent);
        app.patch("/tabitha/calendar/{event_id}", calendarController.updateEvent);

        app.start();
    }
}