package com.tabitha.service;

import java.util.List;

import com.tabitha.entities.Notebook;

public interface NotebookServiceInterface {

    // retrieve all notebook entries
    List<Notebook> serviceGetAllNotebookEntries();

    // retrieve notebook entry by user id
    List<Notebook> serviceGetAllNotebookEntriesByUserId(int task_user_id);

    // retrieve notebook entry by notebook id
    List<Notebook> serviceGetAllNotebookEntriesByNotebookId(int notebook_id);

    // create notebook entry
    Notebook serviceCreateNotebookEntry(Notebook newNotebookEntry);

    // delete notebook entry
    boolean serviceRemoveNotebookEntry(Notebook notebookEntryToBeDeleted);  

    // update notebook entry
    Notebook serviceUpdateNotebookEntry(Notebook updatedNotebookEntry);
    
}
