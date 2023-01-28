package com.tabitha.exceptions;

public class InvalidCalendar extends RuntimeException {
    public InvalidCalendar (String message){
        super(message);
    }
}
