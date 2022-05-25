package com.greg.common.commands.exceptions;

public class LimitExceededException extends Exception{
    public  LimitExceededException(String message){
        super(message);
    }
}
