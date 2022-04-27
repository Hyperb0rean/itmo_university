package com.greg.server.commands;

import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.util.CollectionManager;
import com.greg.server.util.ServerCommandManager;

public class InfoCommand extends Command {

    private final CollectionManager target;

    public InfoCommand(ServerCommandManager manager,CollectionManager target) {
        super("info", "Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", manager);
        this.target = target;
    }

    public CollectionManager getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument == null || argument.isEmpty()){
                String[] temp = target.getOrganizations().getClass().toString().split("\\.");
                this.getManager().getOutput().write("Collection Type: " + temp[temp.length -1] + "\n"+
                        "Number of elements:  " + target.getOrganizations().size() + "\n" +
                        "Date created:  " + target.getInitDate() + "\n" +
                        "Date modified:  " + target.getModDate() + "\n");
                return true;
            }
            else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }
}
