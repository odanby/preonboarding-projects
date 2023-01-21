package com.tabitha.unit.repository;

import org.junit.Test;

import com.tabitha.entities.Notebook;
import com.tabitha.repository.NotebookDAO;
import com.tabitha.repository.NotebookDAOInterface;

import java.sql.Date;

import java.util.List;

import org.junit.Assert;

public class NotebookTests {

    public static NotebookDAOInterface notebookDao = new NotebookDAO();

    // retrieve all notebook entries
        // List<Notebook> getAllNotebookEntries();
    @Test
    public void getAllNotebookEntries(){
        List<Notebook> notebookList = notebookDao.getAllNotebookEntries();
        Assert.assertTrue(notebookList.size() >= 1);
    }

    // retrieve notebook entry by user id
        // List<Notebook> getAllNotebookEntriesByUserId(int task_user_id);
    @Test
    public void getAllNotebookEntriesByUserId(){
        List<Notebook> result = notebookDao.getAllNotebookEntriesByUserId(1);
        Assert.assertNotNull(result);
    }

    // retrieve notebook entry by notebook id
        // List<Notebook> getAllNotebookEntriesByNotebookId(int notebook_id);
    @Test 
    public void getAllNotebookEntriesByNotebookId(){
        List<Notebook> result = notebookDao.getAllNotebookEntriesByNotebookId(1);
        Assert.assertNotNull(result);
    }

    // create notebook entry
        // Notebook createNotebookEntry(Notebook newNotebookEntry);
    @Test
    public void createNotebookEntry(){
        String str = "2023-01-20";
        Date date = Date.valueOf(str);
        Notebook testEntry = new Notebook(0, "Testing repo", date, "Today I am testing my notebook", 1);
        Notebook result = notebookDao.createNotebookEntry(testEntry);
        Assert.assertNotNull(result.getNotebook_id());
    }

    // delete notebook entry
        // boolean removeNotebookEntry(Notebook notebookEntryToBeDeleted); 
    @Test
    public void removeNotebookEntry(){
        String str = "2023-01-20";
        Date date = Date.valueOf(str);
        Notebook entryToBeDeleted = new Notebook(-1, "Delete me", date, "Delete me", 1);
        notebookDao.createNotebookEntry(entryToBeDeleted);
        boolean result = notebookDao.removeNotebookEntry(entryToBeDeleted);
        Assert.assertTrue(result);
    }

    // update notebook entry
        // Notebook updateNotebookEntry(Notebook updatedNotebookEntry);
    @Test 
    public void updateNotebookEntry(){
        String str = "2023-01-20";
        Date date = Date.valueOf(str);
        Notebook updatedEntry = new Notebook(2, "Update to testing repo", date, "Today I am testing my notebook", 1);
        Notebook result = notebookDao.updateNotebookEntry(updatedEntry);
        Assert.assertEquals("Update to testing repo", result.getEntry_title());
    }
}