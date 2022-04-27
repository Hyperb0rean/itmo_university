package com.greg.server.commands;

import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.util.CollectionManager;
import com.greg.server.util.ServerCommandManager;

import java.util.concurrent.atomic.AtomicReference;

public class ShowCommand extends Command{

    private final CollectionManager target;

    public ShowCommand(ServerCommandManager manager,CollectionManager target) {
        super("show", "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении",manager);
        this.target = target;
    }

    public CollectionManager getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()){
                AtomicReference<String> result = new AtomicReference<>("");
                target.getOrganizations().stream().forEach(o -> result.set(result + o.toString() +"\n"));
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
