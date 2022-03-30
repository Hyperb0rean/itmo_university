package com.greg.client.commands;

import com.greg.client.data.Organization;
import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.util.OrganisationStorage;

public class FilterContainsNameCommand extends  Command{
    private final OrganisationStorage target;

    public FilterContainsNameCommand(OrganisationStorage target) {
        super("filter_contains_name", "Выывести элементы, значение поля name которых содержит заданную подстроку");
        this.target = target;
    }

    public OrganisationStorage getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(!argument.isEmpty()){
                for (Organization o:target.getOrganizations()) {
                    if(o.getName().contains(argument)){
                        System.out.println(o.toString());
                    }
                }
                return true;
            }
            else throw new IllegalArgumentException("Нужно ввести подстроку");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
