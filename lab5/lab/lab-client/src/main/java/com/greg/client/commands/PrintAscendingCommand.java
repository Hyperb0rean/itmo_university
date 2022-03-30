package com.greg.client.commands;

import com.greg.client.data.Organization;
import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.util.OrganisationStorage;

import java.util.Collections;
import java.util.LinkedList;

public class PrintAscendingCommand extends Command{
    private final OrganisationStorage target;

    public PrintAscendingCommand(OrganisationStorage target) {
        super("print_ascending", "Вывести элементы коллекции в порядке возрастания");
        this.target = target;
    }

    public OrganisationStorage getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            LinkedList<Organization> sorted = target.getOrganizations();
            Collections.sort(sorted);
            if(argument.isEmpty()){
                for (Organization o:sorted) {
                    System.out.println(o.toString());
                }
                return true;
            }
            else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
