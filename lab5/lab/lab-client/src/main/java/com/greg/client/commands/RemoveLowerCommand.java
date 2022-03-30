package com.greg.client.commands;

import com.greg.client.data.Organization;
import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.util.OrganisationStorage;

public class RemoveLowerCommand extends Command{
    private final OrganisationStorage target;

    public RemoveLowerCommand(OrganisationStorage target) {
        super("remove_lower", "удалить из коллекции все элементы, меньшие, чем заданный");
        this.target = target;
    }

    public OrganisationStorage getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()){
                Organization result = readOrganisation();
                result.generateId();
                target.getOrganizations().removeIf(o -> o.compareTo(result) < 0);
                System.out.println("Элементы успешно удалены!");
                return true;
            }
            else throw new IllegalArgumentException("Невозможно применить команду без аргументов");
        } catch (IllegalArgumentException  | NumberFormatException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
