package com.greg.server.commands;

import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.util.CollectionManager;
import com.greg.server.util.ServerCommandManager;

import java.util.Collections;

public class PrintFieldDescendingCommand extends Command {
    private final CollectionManager target;

    public PrintFieldDescendingCommand(ServerCommandManager manager, CollectionManager target) {
        super("print_field_descending_employees_count", "Вывести значения поля employeesCount всех элементов в порядке убывания",manager);
        this.target = target;
    }

    public CollectionManager getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try {
//            LinkedList<Organization> sorted = target.getOrganizations();
//            Collections.sort(sorted);
//            Collections.reverse(sorted);
            if (argument.isEmpty()) {
//                for (Organization o : sorted) {
//                    System.out.println(o.getEmployeesCount());
//                }
                target.getOrganizations().stream().map(o -> o.getEmployeesCount()).sorted(Collections.reverseOrder()).forEach(o->this.getManager().getOutput().write(o.toString()));
                return true;
            } else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }
}