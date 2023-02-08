package com.tabitha.unit.repository;

import com.tabitha.entities.TaskList;
import com.tabitha.repository.TaskListDAO;
import com.tabitha.repository.TaskListDAOInterface;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TaskListTests {

    public static TaskListDAOInterface tasklistDao = new TaskListDAO();

    // retrieve all tasks
        // List<TaskList> getAllTasks();
    @Test
    public void getAllTasks(){
        List<TaskList> tasklistList = tasklistDao.getAllTasks();
        Assert.assertTrue(tasklistList.size() >= 1);
    }

    // retrieve task by user id
        // List<TaskList> getAllTasksByUserId(int task_user_id);
    @Test
    public void getAllTasksByUserId(){
        List<TaskList> result = tasklistDao.getAllTasksByUserId(1);
        Assert.assertNotNull(result);
    }

    // retrieve task by task id
        // List<TaskList> getAllTasksByTaskId(int task_id);
    @Test
    public void getAllTasksByTaskId(){
        List<TaskList> result = tasklistDao.getAllTasksByTaskId(3);
        Assert.assertNotNull(result);
    }

    // retrieve task by task id
    @Test
    public void getAllTasksByCategoryId(){
        List<TaskList> result = tasklistDao.getAllTasksByCategoryId(1);
        Assert.assertNotNull(result);
    }
    
    // create a task
        // TaskList createTask(TaskList newTask);
    @Test
    public void createTask(){
        TaskList tasklistList = new TaskList(0, "Do my tests", 1, "N", 1, 1);
        TaskList result = tasklistDao.createTask(tasklistList);
        Assert.assertNotNull(result.getTask_id());
    }

    // delete a task
        // boolean removeTask(TaskList taskToBeDeleted);
    @Test
    public void removeTask(){
        TaskList tasklistToBeDeleted = new TaskList(-1, "Delete me", 1, "Y", 1, 1);
        tasklistDao.createTask(tasklistToBeDeleted);
        boolean result = tasklistDao.removeTask(tasklistToBeDeleted);
        Assert.assertTrue(result);
    }

    // update a task
        // TaskList updateTaskList(TaskList updatedTaskList);
    @Test
    public void updateTaskList(){
        TaskList updatedTask = new TaskList(3, "Do my tests", 1, "Y", 1, 1);
        TaskList result = tasklistDao.updateTaskList(updatedTask);
        Assert.assertEquals("Y", result.getTask_status());
    }
}