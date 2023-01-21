package com.tabitha.repository;

import java.util.List;

import com.tabitha.entities.TaskList;
import com.tabitha.utils.HibernateUtil;

public class TaskListDAO implements TaskListDAOInterface {

    @Override
    public List<TaskList> getAllTasks() {
        HibernateUtil.beginTransaction();
        List<TaskList> requestList = HibernateUtil.getSession().createQuery("from TaskList", TaskList.class).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public List<TaskList> getAllTasksByUserId(int task_user_id) {
        HibernateUtil.beginTransaction();
        List<TaskList> requestList = HibernateUtil.getSession().createQuery("from TaskList where task_user_id = :TaskUserId", TaskList.class).setParameter("TaskUserId", task_user_id).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public List<TaskList> getAllTasksByTaskId(int task_id) {
        HibernateUtil.beginTransaction();
        List<TaskList> requestList = HibernateUtil.getSession().createQuery("from TaskList where task_id = :TaskId", TaskList.class).setParameter("TaskId", task_id).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public TaskList createTask(TaskList newTask) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newTask);
        HibernateUtil.endTransaction();
        return newTask;
    }

    @Override
    public boolean removeTask(TaskList taskToBeDeleted) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(taskToBeDeleted);
        HibernateUtil.endTransaction();
        return true;
    }

    @Override
    public TaskList updateTaskList(TaskList updatedTaskList) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(updatedTaskList);
        HibernateUtil.endTransaction();
        return updatedTaskList;
    }
    
}
