package com.greg.server.commands;

import com.greg.common.util.data.Organization;
import com.greg.common.commands.exceptions.IllegalArgumentException;
import com.greg.server.util.CollectionManager;
import com.greg.server.util.DatabaseManager;
import com.greg.server.util.ServerCommandManager;
import com.greg.server.util.FileManager;

import java.sql.SQLException;

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
            if(argument == null || argument.isEmpty()){
                Organization result = this.getManager().getInput().readOrganisation();
                result.generateId();
                if(target.getClass().equals(DatabaseManager.class))
                {
                    DatabaseManager databaseManager = (DatabaseManager) target;
                    for (Organization o: target.getOrganizations()) {
                        if(o.compareTo(result)<0) databaseManager.remove(o.getId(), getManager().getCurrentUser());
                    }
                }
                target.getOrganizations().removeIf(o -> o.compareTo(result) < 0);
                this.getManager().getOutput().write("Элементы успешно удалены!");
                return true;
            }
            else throw new IllegalArgumentException("Невозможно применить команду без аргументов");
        } catch (IllegalArgumentException | NumberFormatException | SQLException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }

}
