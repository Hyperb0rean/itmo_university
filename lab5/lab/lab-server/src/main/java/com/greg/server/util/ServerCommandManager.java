package com.greg.server.util;

import com.google.gson.GsonBuilder;
import com.greg.common.util.data.User;
import com.greg.server.commands.Command;
import com.greg.common.util.data.Organization;
import com.greg.server.util.io.Readable;
import com.greg.server.util.io.Writable;

import java.util.*;

public class ServerCommandManager {

    private final Queue<String> history;
    private final Map<String, Command> commands;
    private Readable input;
    private Writable output;
    private boolean programState = true;
    private Organization tempOrganisation;
    private User currentUser;

    public Queue<String> getHistory() {
        return history;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public synchronized boolean isProgramState() {
        return programState;
    }

    public void setProgramState(boolean programState) {
        this.programState = programState;
    }

    public Readable getInput() {
        return input;
    }

    public void setInput(Readable input) {
        this.input = input;
    }

    public Writable getOutput() {
        return output;
    }

    public void setOutput(Writable output) {
        this.output = output;
    }

    public Organization getTempOrganisation() {
        return tempOrganisation;
    }


    public  boolean executeCommand(String message){


        String username = message.split(" ")[0];
        String command = message.substring(username.length()+1).split(" ")[0];
        String argument = message.substring(username.length()+command.length()+2);
        if(command.equals("add")  || command.equals("remove_lower")){
            GsonBuilder builder = new GsonBuilder();
            this.tempOrganisation = builder.create().fromJson(argument,Organization.class);
            argument= null;
        }
        else if(command.equals("update")){
            argument= message.split(" ")[1];
            String org = message.substring(argument.length() +command.length()+1);
            GsonBuilder builder = new GsonBuilder();
            this.tempOrganisation = builder.create().fromJson(org,Organization.class);

        }
        else if(command.equals("register") || command.equals("login")){
            GsonBuilder builder = new GsonBuilder();
            this.currentUser = builder.create().fromJson(argument,User.class);
            argument=null;
        }
        currentUser.setName(username);
        commands.get(command).execute(argument);
        Date date = new Date();
        history.add(date.toString() + ";     " + command);
        return true;
    }

    public ServerCommandManager() {
        this.history = new PriorityQueue<String>();
        this.commands = new HashMap<String,Command>();
    }


    public User getCurrentUser() {
        return currentUser;
    }
}
