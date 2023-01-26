package com.tabitha.utils;

import com.tabitha.entities.TaskList;

public class TaskListBusinessRules {
    
    // task status can only be "Y" or "N"
    // this is an experimental one
    public boolean containsYOrN(TaskList taskStatusToCheck, String stringTaskStatusToCheck){
        if(taskStatusToCheck.getTask_status().length() <= 1 && stringTaskStatusToCheck.contains("Y") || stringTaskStatusToCheck.contains("N")){
            return true;
        } else {
            return false;
        }
    }

    // task desc can only be 300 characters
    public boolean checkTaskDescLength(TaskList taskDescToCheck){
        if(taskDescToCheck.getTask_desc().length() > 300){
            return false;
        } else {
            return true;
        }
    }
}
