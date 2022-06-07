package com.greg.server.commands;

import com.greg.common.commands.exceptions.IllegalArgumentException;
import com.greg.server.util.CollectionManager;
import com.greg.server.util.DatabaseManager;
import com.greg.server.util.FileManager;
import com.greg.server.util.ServerCommandManager;

import java.sql.SQLException;

public class ClearCommand extends Command{
    private final CollectionManager target;

    public ClearCommand(ServerCommandManager manager, CollectionManager target) {
        super("clear", "Очистить коллекцию",manager);
        this.target = target;
    }

    public CollectionManager getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument == null || argument.isEmpty()){

                if(target.getClass().equals(DatabaseManager.class))
                {
                    DatabaseManager databaseManager = (DatabaseManager) target;
                    databaseManager.clear(getManager().getCurrentUser());
                }
                target.getOrganizations().clear();
                this.getManager().getOutput().write("Коллекция успешно очищена!");
                return true;
            }
            else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException | SQLException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }
}
