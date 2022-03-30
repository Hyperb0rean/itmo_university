package com.greg.client.exceptions;

public class LimitExceededException extends Exception{
    public  LimitExceededException(String message){
        super(message);
    }
}
