package com.greg.client.util;

import com.greg.client.commands.Command;
import com.greg.client.exceptions.CommandNotExistsException;
import com.greg.client.exceptions.EmptyInputException;

import java.util.*;

public class CommandManager {
    private final Queue<String> history;
    private final Map<String, Command> commands;
    private int recursionDepth = 0;
    private boolean programmState = true;

    public Queue<String> getHistory() {
        return history;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public int getRecursionDepth() {
        return recursionDepth;
    }

    public void setRecursionDepth(int recursionDepth) {
        this.recursionDepth = recursionDepth;
    }

    public boolean isProgrammState() {
        return programmState;
    }

    public void setProgrammState(boolean programmState) {
        this.programmState = programmState;
    }

    public boolean executeCommand(String message){
        try {
            boolean validation;
            String command = message.split(" ")[0];
            String argument = "";
            if(command.length()!=message.length()){
                argument = message.substring(command.length()+1);
            }
            if(!message.isEmpty()){
                validation =  commands.containsKey(message.split(" ")[0]);
            }
            else throw new EmptyInputException("Не корректный ввод команды, попробуйте еще раз");

            if(validation){
               commands.get(command).execute(argument);
               Date date = new Date();
               history.add(date.toString() + ";     " + command);
            }
            else throw new CommandNotExistsException("Такой команды не существует, попробуйте еще раз");

        } catch (CommandNotExistsException | EmptyInputException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    public CommandManager() {
        this.history = new PriorityQueue<String>();
        this.commands = new HashMap<String,Command>();
    }


}
