package com.tabitha.unit.service;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.tabitha.entities.TaskList;
import com.tabitha.repository.TaskListDAO;
import com.tabitha.repository.TaskListDAOInterface;
import com.tabitha.service.TaskListService;
import com.tabitha.service.TaskListServiceInterface;
import com.tabitha.utils.TaskListBusinessRules;

public class TaskListServiceTests {

    public static TaskListDAOInterface tasklistDao;
    public static TaskListServiceInterface tasklistService;
    public static TaskListBusinessRules tasklistBusinessRules;

    // mockito mock tests
    public static TaskListDAOInterface mockTasklistDao;
    public static TaskListBusinessRules mockTasklistRules;
    public static TaskListServiceInterface tasklistServiceWithMocks;

    @BeforeClass
    public static void setup(){        

        tasklistBusinessRules = new TaskListBusinessRules();
        tasklistDao = new TaskListDAO();
        tasklistService = new TaskListService(tasklistDao, tasklistBusinessRules);

        mockTasklistDao = Mockito.mock(TaskListDAO.class);
        mockTasklistRules = Mockito.mock(TaskListBusinessRules.class);
        tasklistServiceWithMocks = new TaskListService(mockTasklistDao, mockTasklistRules);
    }
    
    // check if task status is 1 characters and either Y or N
    @Test
    public void invalidTaskStatus(){
        TaskList badTaskStatus = new TaskList("Description", 2, "O", 1, 1);
        boolean result = tasklistBusinessRules.containsYOrN(badTaskStatus);
        Assert.assertFalse(result);
    }

    @Test
    public void validTaskStatus(){
        TaskList goodTaskStatus = new TaskList("Description", 2, "N", 1, 1);
        boolean result = tasklistBusinessRules.containsYOrN(goodTaskStatus);
        Assert.assertTrue(result);
    }

    // check task desc length 
    @Test
    public void invalidTaskDesc(){
        TaskList badTaskDesc = new TaskList("DescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescriptionDescription", 2, "N", 1, 1);
        boolean result = tasklistBusinessRules.checkTaskDescLength(badTaskDesc);
        Assert.assertFalse(result);
    }

    @Test
    public void validTaskDesc(){
        TaskList goodTaskDesc = new TaskList("Description", 2, "N", 1, 1);
        boolean result = tasklistBusinessRules.checkTaskDescLength(goodTaskDesc);
        Assert.assertTrue(result);
    }

    // retrieve all tasks
    @Test
    public void getAllTasks(){
        List<TaskList> result = tasklistService.serviceGetAllTasks();
        Assert.assertNotNull(result);
    }

    // retrieve task by user id - success
    @Test
    public void successGetTaskUserId(){
        List<TaskList> result = tasklistService.serviceGetAllTasksByUserId(1);
        Assert.assertNotNull(result);
    }

    // retrieve task by task id - success
    @Test
    public void successGetTaskTaskId(){
        List<TaskList> result = tasklistService.serviceGetAllTasksByTaskId(1);
        Assert.assertNotNull(result);
    }

    // retrieve task by category id - success
    @Test
    public void successGetTaskCategoryId(){
        List<TaskList> result = tasklistService.serviceGetAllTasksByCategoryId(1);
        Assert.assertNotNull(result);
    }

    // create a task - success
    @Test
    public void successfulTask(){
        TaskList goodTask = new TaskList("Description", 1, "N", 1, 1);

        Mockito.when(mockTasklistRules.containsYOrN(goodTask)).thenReturn(true);
        Mockito.when(mockTasklistRules.checkTaskDescLength(goodTask)).thenReturn(true);

        TaskList greatTask = new TaskList(-10000, "Description", 1, "N", 1, 1);
        Mockito.when(mockTasklistDao.createTask(goodTask)).thenReturn(greatTask);

        TaskList result = tasklistServiceWithMocks.serviceCreateTask(goodTask);
        Assert.assertNotNull(result.getTask_id());
    }

    // delete a task - sucess
    @Test
    public void deleteTask(){
        TaskList goodTask = new TaskList("Description", 1, "N", 1, 1);

        Mockito.when(mockTasklistRules.containsYOrN(goodTask)).thenReturn(true);
        Mockito.when(mockTasklistRules.checkTaskDescLength(goodTask)).thenReturn(true);

        TaskList greatTask = new TaskList(-10000, "Description", 1, "N", 1, 1);
        Mockito.when(mockTasklistDao.createTask(goodTask)).thenReturn(greatTask);

        tasklistServiceWithMocks.serviceCreateTask(goodTask);
        boolean result = tasklistService.serviceRemoveTask(goodTask);

        Assert.assertTrue(result);
    }

    // update a task - success
    @Test
    public void updateTask(){
        TaskList goodTask = new TaskList("Description", 1, "Y", 1, 1);

        Mockito.when(mockTasklistRules.containsYOrN(goodTask)).thenReturn(true);
        Mockito.when(mockTasklistRules.checkTaskDescLength(goodTask)).thenReturn(true);

        TaskList greatTask = new TaskList(-10000, "Description", 1, "N", 1, 1);
        Mockito.when(mockTasklistDao.updateTaskList(goodTask)).thenReturn(greatTask);

        TaskList result = tasklistServiceWithMocks.serviceUpdateTaskList(goodTask);
        Assert.assertNotNull(result.getTask_status());
    }
}
