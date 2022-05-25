package com.greg.client.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greg.common.util.data.Organization;

import java.nio.charset.StandardCharsets;

public class Request {
    private String command;
    private String argument;
    private Object data;


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public byte[] getBytes(){
        StringBuilder result = new StringBuilder();
        result.append(command).append(argument).append(" ");
        if(data != null){
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            result.append(gson.toJson(data));
        }

        return result.toString().getBytes(StandardCharsets.UTF_8);
    }
}
