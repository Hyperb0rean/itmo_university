package com.greg.common.commands.exceptions;

public class CommandNotExistsException extends Exception{
    public CommandNotExistsException(String message) {
        super(message);
    }
}
