package com.greg.server.commands;

import com.greg.server.data.Organization;
import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.util.ServerCommandManager;
import com.greg.server.util.CollectionManager;

public class AddCommand extends Command{

    private final CollectionManager target;

    public AddCommand( ServerCommandManager manager, CollectionManager target) {
        super("add", "Добавить новый элемент в коллекцию",manager);
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
                target.getOrganizations().add(result);
                this.getManager().getOutput().write("Элемент успешно добавлен!");
                return true;

            }
            else throw new IllegalArgumentException("Невозможно применить команду без аргументов");
        } catch (Exception  e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }
}
