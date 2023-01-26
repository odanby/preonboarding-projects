package com.tabitha.exceptions;

public class InvalidTask extends RuntimeException {
    public InvalidTask (String message){
        super(message);
    }
}