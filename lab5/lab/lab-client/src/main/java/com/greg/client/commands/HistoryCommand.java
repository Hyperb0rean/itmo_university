package com.greg.client.commands;

import com.greg.client.exceptions.IllegalArgumentException;

import java.util.Queue;

public class HistoryCommand extends Command{
    private final Queue<String> target;

    public HistoryCommand(Queue<String> target) {
        super("history", "Ввывести последние 10 команд (без их аргументов)");
        this.target = target;
    }

    public Queue<String> getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()){
                for (int i =0; i<Math.min(10,target.size());i++){
                    System.out.println(target.toArray()[i]);
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
