package com.greg.client.commands;

import com.greg.client.exceptions.IllegalArgumentException;

import java.util.Map;

public class HelpCommand extends Command{

    private final Map<String,Command> target;

    public HelpCommand(Map<String,Command> target) {
        super("help", "Вывести справку по доступным командам");
        this.target = target;
    }

    public Map<String, Command> getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()){
                for (Command command: target.values()) {
                    System.out.println(command.getName() + " -- " + command.getDescription());
                }
                return true;
            }
            else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }

    }
}
