package com.greg.client.commands;

import com.greg.client.data.Organization;
import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.exceptions.NoSuchElementException;
import com.greg.client.util.OrganisationStorage;

public class UpdateCommand extends Command {

    private final OrganisationStorage target;

    public UpdateCommand(OrganisationStorage target) {
        super("update", "Обновить значение элемента коллекции, id которого равен заданному");
        this.target = target;
    }

    public OrganisationStorage getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                Organization result = readOrganisation();
                result.setId(Integer.parseInt(argument));
                boolean idFoundFlag = false;
                for (Organization o : target.getOrganizations()) {

                    if (o.getId() == result.getId()) {
                        idFoundFlag = true;
                        o = result;
                    }
                }
                if (!idFoundFlag) throw new NoSuchElementException("Не существует элемента с таким id");
                System.out.println("Элемент успешно обновлен!");
                return true;
            } else throw new IllegalArgumentException("Невозможно применить команду без аргументов");
        } catch (IllegalArgumentException | NumberFormatException | NoSuchElementException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
