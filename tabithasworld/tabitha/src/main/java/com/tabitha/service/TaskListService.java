package com.tabitha.service;

import java.util.List;

import com.tabitha.entities.TaskList;
import com.tabitha.exceptions.InvalidTask;
import com.tabitha.repository.TaskListDAOInterface;
import com.tabitha.utils.TaskListBusinessRules;

public class TaskListService implements TaskListServiceInterface {

    private TaskListDAOInterface tasklistDao;
    private TaskListBusinessRules tasklistBusinessRules;

    public TaskListService(TaskListDAOInterface tasklistDao, TaskListBusinessRules tasklistBusinessRules){
        this.tasklistDao = tasklistDao;
        this.tasklistBusinessRules = tasklistBusinessRules;
    }

    @Override
    public List<TaskList> serviceGetAllTasks() {
        return this.tasklistDao.getAllTasks();
    }

    @Override
    public List<TaskList> serviceGetAllTasksByUserId(int task_user_id) {
        return this.tasklistDao.getAllTasksByUserId(task_user_id);
    }

    @Override
    public List<TaskList> serviceGetAllTasksByTaskId(int task_id) {
        return this.tasklistDao.getAllTasksByTaskId(task_id);
    }

    @Override
    public List<TaskList> serviceGetAllTasksByCategoryId(int category_id) {
        return this.tasklistDao.getAllTasksByCategoryId(category_id);
    }

    @Override
    public TaskList serviceCreateTask(TaskList newTask) {
        boolean valCheck1 = tasklistBusinessRules.checkTaskDescLength(newTask);
        boolean valCheck2 = tasklistBusinessRules.containsYOrN(newTask);
        
        if(valCheck1 && valCheck2){
            return this.tasklistDao.createTask(newTask);
        } else {
            throw new InvalidTask("Could not create new task.");
        }
    }

    @Override
    public boolean serviceRemoveTask(TaskList taskToBeDeleted) {
        return this.tasklistDao.removeTask(taskToBeDeleted);
    }

    @Override
    public TaskList serviceUpdateTaskList(TaskList updatedTaskList) {
        boolean valCheck1 = tasklistBusinessRules.checkTaskDescLength(updatedTaskList);
        boolean valCheck2 = tasklistBusinessRules.containsYOrN(updatedTaskList);

        if(valCheck1 && valCheck2){
            return this.tasklistDao.updateTaskList(updatedTaskList);
        } else {
            throw new InvalidTask("Could not update task.");
        }
    }
    
}
