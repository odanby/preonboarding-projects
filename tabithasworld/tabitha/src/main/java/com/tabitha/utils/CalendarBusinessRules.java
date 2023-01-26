package com.tabitha.utils;

import com.tabitha.entities.Calendar;

public class CalendarBusinessRules {

    // make sure calendar date is no earlier than 2023 and no further than 2023
    // experimental, let's see if this works!
    public boolean checkDateValidity(Calendar dateToCheck){

        String dateStartInput = "2023-01-01 00:00:00";
        String dateEndInput = "2023-12-31 23:59:59";
        java.sql.Timestamp tsStart = java.sql.Timestamp.valueOf(dateStartInput);
        java.sql.Timestamp tsEnd = java.sql.Timestamp.valueOf(dateEndInput);
        java.sql.Timestamp tsCurrent = java.sql.Timestamp.valueOf(dateToCheck);

        if(tsCurrent.after(tsStart) && tsCurrent.before(tsEnd) || tsCurrent.equals(tsStart) || tsCurrent.equals(tsEnd)){
            return true;
        } else {
            return false;
        }
    }

    // event title is a 50 character limit
    public boolean checkEventTitleLength(Calendar eventTitleToCheck){
        if(eventTitleToCheck.getEvent_title().length() > 50){
            return false;
        } else {
            return true;
        }
    }

    // event desc is a 300 character limit
    public boolean checkEventDescLength(Calendar eventDescToCheck){
        if(eventDescToCheck.getEvent_desc().length() > 300){
            return false;
        } else {
            return true;
        }
    }

    // event status can only be either "Y" or "N"
    // experimental
    public boolean eventStatusContainsYOrN(Calendar eventStatusToCheck){
        if(eventStatusToCheck.getEvent_status().length() <= 1 && eventStatusToCheck.getEvent_status().contains("Y") || eventStatusToCheck.getEvent_status().contains("N")){
            return true;
        } else {
            return false;
        }
    }

    // day status can only be either "Y" or "N"
    // experimental!
    public boolean dayStatusContainsYOrN(Calendar dayStatusToCheck){
        if(dayStatusToCheck.getDay_status().length() <= 1 && dayStatusToCheck.getDay_status().contains("Y") || dayStatusToCheck.getDay_status().contains("N")){
            return true;
        } else {
            return false;
        }
    }
}
