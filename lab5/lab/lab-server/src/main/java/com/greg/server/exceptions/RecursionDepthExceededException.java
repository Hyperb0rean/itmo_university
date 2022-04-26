package com.greg.server.exceptions;

public class RecursionDepthExceededException extends Exception{
    public RecursionDepthExceededException(String message) {
        super(message);
    }
}
