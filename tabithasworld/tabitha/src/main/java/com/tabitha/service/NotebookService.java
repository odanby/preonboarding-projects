package com.tabitha.service;

import java.util.List;

import com.tabitha.entities.Notebook;
import com.tabitha.exceptions.InvalidNotebook;
import com.tabitha.repository.NotebookDAOInterface;
import com.tabitha.utils.NotebookBusinessRules;

public class NotebookService implements NotebookServiceInterface {

    private NotebookDAOInterface notebookDao;
    private NotebookBusinessRules notebookBusinessRules;

    public NotebookService(NotebookDAOInterface notebookDao, NotebookBusinessRules notebookBusinessRules){
        this.notebookDao = notebookDao;
        this.notebookBusinessRules = notebookBusinessRules;
    }

    @Override
    public List<Notebook> serviceGetAllNotebookEntries() {
        return this.notebookDao.getAllNotebookEntries();
    }

    @Override
    public List<Notebook> serviceGetAllNotebookEntriesByUserId(int task_user_id) {
        return this.notebookDao.getAllNotebookEntriesByUserId(task_user_id);
    }

    @Override
    public List<Notebook> serviceGetAllNotebookEntriesByNotebookId(int notebook_id) {
        return this.notebookDao.getAllNotebookEntriesByNotebookId(notebook_id);
    }

    @Override
    public Notebook serviceCreateNotebookEntry(Notebook newNotebookEntry) {
        boolean valCheck1 = this.notebookBusinessRules.checkNotebookEntryLength(newNotebookEntry);
        boolean valCheck2 = this.notebookBusinessRules.checkNotebookTitleLength(newNotebookEntry);

        if(valCheck1 && valCheck2){
            return this.notebookDao.createNotebookEntry(newNotebookEntry);
        } else {
            throw new InvalidNotebook("Could not create notebook entry.");
        }
    }

    @Override
    public boolean serviceRemoveNotebookEntry(Notebook notebookEntryToBeDeleted) {
        return this.notebookDao.removeNotebookEntry(notebookEntryToBeDeleted);
    }

    @Override
    public Notebook serviceUpdateNotebookEntry(Notebook updatedNotebookEntry) {
        boolean valCheck1 = this.notebookBusinessRules.checkNotebookEntryLength(updatedNotebookEntry);
        boolean valCheck2 = this.notebookBusinessRules.checkNotebookTitleLength(updatedNotebookEntry);

        if(valCheck1 && valCheck2){
            return this.notebookDao.updateNotebookEntry(updatedNotebookEntry);
        } else {
            throw new InvalidNotebook("Could not update notebook entry.");
        }
    }
    
}
