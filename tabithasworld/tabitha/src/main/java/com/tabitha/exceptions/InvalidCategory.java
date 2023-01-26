package com.tabitha.exceptions;

public class InvalidCategory extends RuntimeException {
    public InvalidCategory (String message){
        super(message);
    }
}
