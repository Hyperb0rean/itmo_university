package com.greg.server.commands;

import com.greg.server.data.Organization;
import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.exceptions.NoSuchElementException;
import com.greg.server.util.ServerCommandManager;
import com.greg.server.util.CollectionManager;

public class UpdateCommand extends Command {

    private final CollectionManager target;


    public UpdateCommand(ServerCommandManager manager,CollectionManager target) {
        super("update", "Обновить значение элемента коллекции, id которого равен заданному",manager);
        this.target = target;
    }

    public CollectionManager getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (argument != null || !argument.isEmpty()) {
                Organization result = this.getManager().getInput().readOrganisation();
                result.setId(Integer.parseInt(argument));
                boolean idFoundFlag = false;
                for (Organization o : target.getOrganizations()) {
                    if (o.getId() == result.getId()) {
                        idFoundFlag = true;
                        o = result;
                    }
                }
                if (!idFoundFlag) throw new NoSuchElementException("Не существует элемента с таким id");
                this.getManager().getOutput().write("Элемент успешно обновлен!");
                return true;
            } else throw new IllegalArgumentException("Невозможно применить команду без аргументов");
        } catch (IllegalArgumentException | NumberFormatException | NoSuchElementException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }


}
