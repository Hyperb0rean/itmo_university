package com.greg.client.commands;

import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.util.OrganisationStorage;

public class RemoveHeadCommand extends Command{
    private final OrganisationStorage target;

    public RemoveHeadCommand(OrganisationStorage target) {
        super("remove_head", "вывести первый элемент коллекции и удалить его");
        this.target = target;
    }

    public OrganisationStorage getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()){
                System.out.println(target.getOrganizations().getFirst().toString());
                target.getOrganizations().removeFirst();
                System.out.println("Элемент успешно удален!");
                return true;
            }
            else throw new IllegalArgumentException("Невозможно применить команду без аргументов");
        } catch (IllegalArgumentException  | NumberFormatException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
