package com.greg.client.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.util.OrganisationStorage;

import java.io.*;

public class SaveCommand extends Command{
    private final OrganisationStorage target;

    public SaveCommand(OrganisationStorage target) {
        super("save", "Сохранить коллекцию в файл");
        this.target = target;
    }

    public OrganisationStorage getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(argument.isEmpty()){
                File file = new File(System.getenv("LAB5"));
                //File file = new File("C:\\Users\\jewel\\Documents\\Java\\itmo_university\\lab5\\lab\\lab-client\\src\\main\\java\\com\\greg\\client\\util\\test.json");

                OutputStreamWriter oswr = new OutputStreamWriter(new FileOutputStream(file));

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                String result = gson.toJson(target.getOrganizations());
                oswr.write(result);
                oswr.close();
                System.out.println("Коллекция сохранена успешно");
                return true;
            }
            else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException | IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
