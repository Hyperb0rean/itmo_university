package com.greg.client.util;

import com.greg.client.exceptions.CommandNotExistsException;
import com.greg.client.exceptions.EmptyInputException;

import java.util.HashSet;

public class ClientCommandManager {
    private boolean programmState = true;
    private final HashSet<String> availibleCommands;
    private final RequestManager requestManager;


    public ClientCommandManager() {
        this.availibleCommands = new HashSet<String>();
        availibleCommands.add("help");
        availibleCommands.add("info");
        availibleCommands.add("show");
        availibleCommands.add("add");
        availibleCommands.add("update");
        availibleCommands.add("remove_by_id");
        availibleCommands.add("clear");
        availibleCommands.add("execute_script");
        availibleCommands.add("exit");
        availibleCommands.add("remove_head");
        availibleCommands.add("remove_lower");
        availibleCommands.add("history");
        availibleCommands.add("filter_contains_name");
        availibleCommands.add("print_ascending");
        availibleCommands.add("print_field_descending_employees_count");
        this.requestManager = new RequestManager();
    }

    public boolean isProgrammState() {
        return programmState;
    }

    public void vallidateCommand(String message){
        try {
            boolean validation;
            String command;
            if(!message.equals(" ")){
                command = message.split(" ")[0];
            }
            else throw new EmptyInputException("Не корректный ввод команды, попробуйте еще раз");
            String argument = "";
            if(command.length()!=message.length()){
                argument = message.substring(command.length()+1);
            }
            if(!message.isEmpty()){
                validation =  availibleCommands.contains(message.split(" ")[0]);
            }
            else throw new EmptyInputException("Не корректный ввод команды, попробуйте еще раз");

                if(validation){
                    if(command.equals("exit")){
                        programmState = false;
                    }
                    else if(command.equals("add")   || command.equals("remove_lower")){

                        requestManager.sendRequest(requestManager.makeRequest(command, new Asker().askOrganisation()));
                    }
                    else if(command.equals("update")){
                        requestManager.sendRequest(requestManager.makeRequest(command,argument, new Asker().askOrganisation()));

                    }
                    else {
                        requestManager.sendRequest(requestManager.makeRequest(command, argument));
                    }
                }
                else throw new CommandNotExistsException("Такой команды не существует, попробуйте еще раз");

        } catch (CommandNotExistsException | EmptyInputException e) {
            System.err.println(e.getMessage());
        }
    }

}
