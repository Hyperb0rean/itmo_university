package com.greg.server.commands;

import com.greg.server.data.Organization;
import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.util.ServerCommandManager;
import com.greg.server.util.CollectionManager;

public class RemoveLowerCommand extends Command{
    private final CollectionManager target;



    public RemoveLowerCommand(ServerCommandManager manager, CollectionManager target) {
        super("remove_lower", "удалить из коллекции все элементы, меньшие, чем заданный",manager);
        this.target = target;

    }

    public CollectionManager getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()){
                Organization result = this.getManager().getInput().readOrganisation();
                result.generateId();
                target.getOrganizations().removeIf(o -> o.compareTo(result) < 0);
                this.getManager().getOutput().write("Элементы успешно удалены!");
                return true;
            }
            else throw new IllegalArgumentException("Невозможно применить команду без аргументов");
        } catch (IllegalArgumentException  | NumberFormatException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }

}
