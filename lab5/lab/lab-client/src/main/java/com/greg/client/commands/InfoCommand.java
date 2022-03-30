package com.greg.client.commands;

import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.util.OrganisationStorage;

public class InfoCommand extends Command {

    private final OrganisationStorage target;

    public InfoCommand(OrganisationStorage target) {
        super("info", "Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.target = target;
    }

    public OrganisationStorage getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()){
                String[] temp = target.getOrganizations().getClass().toString().split("\\.");
                System.out.println("Collection Type: " + temp[temp.length -1]);
                System.out.println("Number of elements:  " + target.getOrganizations().size());
                System.out.println("Date created:  " + target.getInitDate());
                System.out.println("Date modified:  " + target.getModDate());
                return true;
            }
            else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
