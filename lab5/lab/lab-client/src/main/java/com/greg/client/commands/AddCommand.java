package com.greg.client.commands;

import com.greg.client.data.Organization;
import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.util.OrganisationStorage;

public class AddCommand extends Command{

    private final OrganisationStorage target;

    public AddCommand(OrganisationStorage target) {
        super("add", "Ддобавить новый элемент в коллекцию");
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
                target.getOrganizations().add(result);
                System.out.println("Элемент успешно добавлен!");
                return true;

            }
            else throw new IllegalArgumentException("Невозможно применить команду без аргументов");
        } catch (Exception  e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
