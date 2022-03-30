package com.greg.client.commands;

import com.greg.client.data.Organization;
import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.exceptions.NoSuchElementException;
import com.greg.client.util.OrganisationStorage;

public class RemoveByIdCommand extends Command{

    private final OrganisationStorage target;

    public RemoveByIdCommand(OrganisationStorage target) {
        super("remove_by_id", "Удалить элемент из коллекции по его id");
        this.target = target;
    }

    public OrganisationStorage getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(!argument.isEmpty()){
                String id = argument.split(" ")[0];

                boolean idFoundFlag = false;
                for (Organization o: target.getOrganizations()) {

                        if(o.getId() == Integer.parseInt(id))
                        {
                            target.getOrganizations().remove(o);
                            idFoundFlag=true;
                        }
                }
                if (!idFoundFlag) throw new NoSuchElementException("Не существует элемента с таким id");
                System.out.println("Элемент успешно удален!");
                return true;
            }
            else throw new IllegalArgumentException("Невозможно применить команду без аргументов");
        } catch (IllegalArgumentException  | NumberFormatException | NoSuchElementException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
