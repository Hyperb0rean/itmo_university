package com.greg.server.commands;

import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.util.ServerCommandManager;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class HelpCommand extends Command{

    private final Map<String,Command> target;

    public HelpCommand(ServerCommandManager manager) {
        super("help", "Вывести справку по доступным командам",manager);
        this.target = this.getManager().getCommands();
    }

    public Map<String, Command> getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()){
//                for (Command command: target.values()) {
//                    System.out.println(command.getName() + " -- " + command.getDescription());
//                }
                AtomicReference<String> result = new AtomicReference<>("");
                target.values().stream().map(command -> command.getName() + " -- " + command.getDescription()).forEach(o -> result.set(result + o+ "\n"));
                this.getManager().getOutput().write(result.toString());
                return true;
            }
            else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }

    }
}
