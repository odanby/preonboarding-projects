package com.tabitha.service;

import java.util.List;

import com.tabitha.entities.TaskList;

public interface TaskListServiceInterface {

        // retrieve all tasks
        List<TaskList> serviceGetAllTasks();

        // retrieve task by user id
        List<TaskList> serviceGetAllTasksByUserId(int task_user_id);
    
        // retrieve task by task id
        List<TaskList> serviceGetAllTasksByTaskId(int task_id);
        
        // retrieve task by category id
        List<TaskList> serviceGetAllTasksByCategoryId(int category_id);

        // create a task
        TaskList serviceCreateTask(TaskList newTask);
    
        // delete a task
        boolean serviceRemoveTask(TaskList taskToBeDeleted);
    
        // update a task
        TaskList serviceUpdateTaskList(TaskList updatedTaskList);
    
}
