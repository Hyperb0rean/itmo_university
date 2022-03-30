package com.greg.client.commands;

import com.greg.client.data.Organization;
import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.util.OrganisationStorage;

public class ShowCommand extends Command{

    private final OrganisationStorage target;

    public ShowCommand(OrganisationStorage target) {
        super("show", "Вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.target = target;
    }

    public OrganisationStorage getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()){
                for (Organization o:target.getOrganizations()) {
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
