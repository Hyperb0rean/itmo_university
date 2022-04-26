package com.greg.server.commands;

import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.util.CollectionManager;
import com.greg.server.util.ServerCommandManager;

public class PrintAscendingCommand extends Command{
    private final CollectionManager target;

    public PrintAscendingCommand(ServerCommandManager manager,CollectionManager target) {
        super("print_ascending", "Вывести элементы коллекции в порядке возрастания",manager);
        this.target = target;
    }

    public CollectionManager getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
//            LinkedList<Organization> sorted = target.getOrganizations();
//            Collections.sort(sorted);
            if(argument.isEmpty()){
//                for (Organization o:sorted) {
//                    System.out.println(o.toString());
//                }
                target.getOrganizations().stream().sorted().forEach(o->this.getManager().getOutput().write(o.toString()));
                return true;
            }
            else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }
}
