package com.greg.server.util;

import com.greg.server.commands.Command;
import com.greg.server.util.io.Readable;
import com.greg.server.util.io.Writable;

import java.util.*;

public class ServerCommandManager {
    private final Queue<String> history;
    private final Map<String, Command> commands;
    private Readable input;
    private Writable output;
    private boolean programState = true;

    public Queue<String> getHistory() {
        return history;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public boolean isProgramState() {
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



    public boolean executeCommand(String message){

        String command;
        command = message.split(" ")[0];
        String argument = message.substring(command.length()+1);
        commands.get(command).execute(argument);
        Date date = new Date();
        history.add(date.toString() + ";     " + command);
        return true;
    }

    public ServerCommandManager() {
        this.history = new PriorityQueue<String>();
        this.commands = new HashMap<String,Command>();
    }



}
