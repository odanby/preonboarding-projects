package com.tabitha.repository;

import java.util.List;

import com.tabitha.entities.Notebook;

public interface NotebookDAOInterface {

    // for notebook i think i'd need:
        // pull notebook by user id
        // pull notebook by notebook id
        // create a notebook entry
        // delete notebook entry
        // update a notebook entry
    
    // retrieve notebook entry by user id
    List<Notebook> getAllNotebookEntriesByUserId(int task_user_id);

    // retrieve notebook entry by notebook id
    List<Notebook> getAllNotebookEntriesByNotebookId(int notebook_id);

    // create notebook entry
    Notebook createNotebookEntry(Notebook newNotebookEntry);

    // delete notebook entry
    boolean removeNotebookEntry(Notebook notebookEntryToBeDeleted);  

    // update notebook entry
    Notebook updateNotebookEntry(Notebook updatedNotebookEntry);
    
}
