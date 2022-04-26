package com.greg.server.commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.util.CollectionManager;
import com.greg.server.util.ServerCommandManager;

import java.io.*;

public class SaveCommand extends Command{
    private final CollectionManager target;

    public SaveCommand(ServerCommandManager manager, CollectionManager target) {
        super("save", "Сохранить коллекцию в файл", manager);
        this.target = target;
    }

    public CollectionManager getTarget() {
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
                this.getManager().getOutput().write("Коллекция сохранена успешно");
                return true;
            }
            else throw new IllegalArgumentException("Эта команда не принимает аргументов");
        } catch (IllegalArgumentException | IOException e) {
            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }
}
