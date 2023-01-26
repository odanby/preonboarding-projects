package com.tabitha.exceptions;

public class InvalidNotebook extends RuntimeException {
    public InvalidNotebook (String message){
        super(message);
    }
}
