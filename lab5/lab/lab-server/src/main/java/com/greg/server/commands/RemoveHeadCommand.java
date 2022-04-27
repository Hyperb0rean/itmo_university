package com.greg.server.commands;

import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.util.CollectionManager;
import com.greg.server.util.ServerCommandManager;

public class RemoveHeadCommand extends Command{
    private final CollectionManager target;

    public RemoveHeadCommand(ServerCommandManager manager, CollectionManager target) {
        super("remove_head", "вывести первый элемент коллекции и удалить его",manager);
        this.target = target;
    }

    public CollectionManager getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument == null || argument.isEmpty()){
                this.getManager().getOutput().write(target.getOrganizations().getFirst().toString());
                target.getOrganizations().removeFirst();
                this.getManager().getOutput().write("Элемент успешно удален!");
                return true;
            }
            else throw new IllegalArgumentException("Невозможно применить команду без аргументов");
        } catch (IllegalArgumentException  | NumberFormatException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }
}
