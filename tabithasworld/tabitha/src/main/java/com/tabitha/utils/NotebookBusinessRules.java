package com.tabitha.utils;

import com.tabitha.entities.Notebook;

public class NotebookBusinessRules {
    
    // notebook title can only be 50 characters
    public boolean checkNotebookTitleLength(Notebook titleToCheck){
        if(titleToCheck.getEntry_title().length() > 50){
            return false;
        } else {
            return true;
        }
    }

    // notebook entry can only be 500 characters
    public boolean checkNotebookEntryLength(Notebook entryToCheck){
        if(entryToCheck.getEntry_content().length() > 500){
            return false;
        } else {
            return true;
        }
    }

}
