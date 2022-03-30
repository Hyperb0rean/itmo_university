package com.greg.client.commands;

import com.greg.client.data.Organization;
import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.util.OrganisationStorage;

import java.util.Collections;
import java.util.LinkedList;

public class PrintFieldDescendingCommand extends Command {
    private final OrganisationStorage target;

    public PrintFieldDescendingCommand(OrganisationStorage target) {
        super("print_field_descending_employees_count", "Вывести значения поля employeesCount всех элементов в порядке убывания");
        this.target = target;
    }

    public OrganisationStorage getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try {
            LinkedList<Organization> sorted = target.getOrganizations();
            Collections.sort(sorted);
            Collections.reverse(sorted);
            if (argument.isEmpty()) {
                for (Organization o : sorted) {
                    System.out.println(o.getEmployeesCount());
                }
                return true;
            } else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}