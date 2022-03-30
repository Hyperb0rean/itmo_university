package com.greg.client.exceptions;

public class RecursionDepthExceededException extends Exception{
    public RecursionDepthExceededException(String message) {
        super(message);
    }
}
