package com.tabitha.utils;

import java.sql.Timestamp;

import com.tabitha.entities.Calendar;

public class CalendarBusinessRules {

    // make sure calendar date is no earlier than 2023 and no further than 2023
    // experimental, let's see if this works!
    public boolean checkDateValidity(Timestamp startDateToCheck, Timestamp endDateToCheck){

        String dateStartInput = "2023-01-01 00:00:00";
        String dateEndInput = "2023-12-31 23:59:59";
        java.sql.Timestamp tsJan01 = java.sql.Timestamp.valueOf(dateStartInput);
        java.sql.Timestamp tsDec31 = java.sql.Timestamp.valueOf(dateEndInput);
        java.sql.Timestamp tsStart = startDateToCheck;
        java.sql.Timestamp tsEnd = endDateToCheck;

        if(tsStart.after(tsJan01) && tsStart.before(tsDec31) || tsStart.equals(tsJan01) || tsStart.equals(tsDec31) 
            && tsEnd.after(tsStart) && tsEnd.before(tsDec31) || tsEnd.equals(tsDec31)){
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
