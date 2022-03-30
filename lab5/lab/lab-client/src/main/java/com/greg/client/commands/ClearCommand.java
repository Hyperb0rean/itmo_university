package com.greg.client.commands;

import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.util.OrganisationStorage;

public class ClearCommand extends Command{
    private final OrganisationStorage target;

    public ClearCommand(OrganisationStorage target) {
        super("clear", "Очистить коллекцию");
        this.target = target;
    }

    public OrganisationStorage getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()){
                target.getOrganizations().clear();
                System.out.println("Коллекция успешно очищена!");
                return true;
            }
            else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
