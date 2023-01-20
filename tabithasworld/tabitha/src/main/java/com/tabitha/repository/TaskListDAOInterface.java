package com.tabitha.repository;

import java.util.List;

import com.tabitha.entities.TaskList;

public interface TaskListDAOInterface {
    
    // for task list
        // retrieve task by task id
        // retrieve all tasks
        // retrieve task by user id
        // delete a task
        // update a task
        // create a task

    // retrieve all tasks
    List<TaskList> getAllTasks();

    // retrieve task by user id
    List<TaskList> getAllTasksByUserId(int task_user_id);

    // retrieve task by task id
    List<TaskList> getAllTasksByTaskId(int task_id);
    
    // create a task
    TaskList createTask(TaskList newTask);

    // delete a task
    boolean removeTask(TaskList taskToBeDeleted);

    // update a task
    TaskList updateTaskList(TaskList updatedTaskList);
}
