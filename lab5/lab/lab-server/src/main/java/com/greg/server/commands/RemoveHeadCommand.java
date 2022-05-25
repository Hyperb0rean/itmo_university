package com.greg.server.commands;

import com.greg.common.commands.exceptions.IllegalArgumentException;
import com.greg.server.util.CollectionManager;
import com.greg.server.util.DatabaseManager;
import com.greg.server.util.FileManager;
import com.greg.server.util.ServerCommandManager;

import java.sql.SQLException;

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
                if(target.getClass().equals(DatabaseManager.class))
                {
                    DatabaseManager databaseManager = (DatabaseManager) target;
                    databaseManager.remove(target.getOrganizations().getFirst().getId(), getManager().getCurrentUser());
                }
                target.getOrganizations().removeFirst();
                this.getManager().getOutput().write("Элемент успешно удален!");
                return true;
            }
            else throw new IllegalArgumentException("Невозможно применить команду без аргументов");
        } catch (IllegalArgumentException | NumberFormatException | SQLException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }
}
