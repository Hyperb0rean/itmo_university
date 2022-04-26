package com.greg.server.commands;

import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.util.CollectionManager;
import com.greg.server.util.ServerCommandManager;

public class FilterContainsNameCommand extends  Command{
    private final CollectionManager target;

    public FilterContainsNameCommand(ServerCommandManager manager, CollectionManager target) {
        super("filter_contains_name", "Выывести элементы, значение поля name которых содержит заданную подстроку",manager);
        this.target = target;
    }

    public CollectionManager getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(!argument.isEmpty()){
//                for (Organization o:target.getOrganizations()) {
//                    if(o.getName().contains(argument)){
//                        System.out.println(o.toString());
//                    }
//                }
                target.getOrganizations().stream().filter(x -> x.getName().contains(argument)).forEach(o -> this.getManager().getOutput().write(o.toString()));
                return true;
            }
            else throw new IllegalArgumentException("Нужно ввести подстроку");
        } catch (IllegalArgumentException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }
}
