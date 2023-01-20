package com.tabitha.repository;

import java.util.List;

import com.tabitha.entities.Notebook;
import com.tabitha.utils.HibernateUtil;

public class NotebookDAO implements NotebookDAOInterface {

    @Override
    public List<Notebook> getAllNotebookEntriesByUserId(int task_user_id) {
        HibernateUtil.beginTransaction();
        List<Notebook> requestList = HibernateUtil.getSession().createQuery("from Notebook where task_user_id = :TaskUserId", Notebook.class).setParameter("TaskUserId", task_user_id).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public List<Notebook> getAllNotebookEntriesByNotebookId(int notebook_id) {
        HibernateUtil.beginTransaction();
        List<Notebook> requestList = HibernateUtil.getSession().createQuery("from Notebook where notebook_id = :NotebookId", Notebook.class).setParameter("NotebookId", notebook_id).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }

    @Override
    public Notebook createNotebookEntry(Notebook newNotebookEntry) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newNotebookEntry);
        HibernateUtil.endTransaction();
        return newNotebookEntry;
    }

    @Override
    public boolean removeNotebookEntry(Notebook notebookEntryToBeDeleted) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(notebookEntryToBeDeleted);
        HibernateUtil.endTransaction();
        return true;
    }

    @Override
    public Notebook updateNotebookEntry(Notebook updatedNotebookEntry) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(updatedNotebookEntry);
        HibernateUtil.endTransaction();
        return updatedNotebookEntry;
    }

    @Override
    public List<Notebook> getAllNotebookEntries() {
        HibernateUtil.beginTransaction();
        List<Notebook> requestList = HibernateUtil.getSession().createQuery("from Notebook", Notebook.class).getResultList();
        HibernateUtil.endTransaction();
        return requestList;
    }
    
}
