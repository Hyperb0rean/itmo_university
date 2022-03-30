package com.greg.client;

import com.greg.client.commands.*;
import com.greg.client.util.CommandManager;
import com.greg.client.util.OrganisationStorage;

import java.util.Scanner;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandManager manager = new CommandManager();
        OrganisationStorage collection = new OrganisationStorage();
        manager.getCommands().put("help", new HelpCommand(manager.getCommands()));
        manager.getCommands().put("info", new InfoCommand(collection));
        manager.getCommands().put("show", new ShowCommand(collection));
        manager.getCommands().put("add", new AddCommand(collection));
        manager.getCommands().put("update", new UpdateCommand(collection));
        manager.getCommands().put("remove_by_id", new RemoveByIdCommand(collection));
        manager.getCommands().put("clear", new ClearCommand(collection));
        manager.getCommands().put("save", new SaveCommand(collection));
        manager.getCommands().put("execute_script", new ExecuteScriptCommand(manager));
        manager.getCommands().put("exit", new ExitCommand(manager));
        manager.getCommands().put("remove_head", new RemoveHeadCommand(collection));
        manager.getCommands().put("remove_lower", new RemoveLowerCommand(collection));
        manager.getCommands().put("history", new HistoryCommand(manager.getHistory()));
        manager.getCommands().put("filter_contains_name", new FilterContainsNameCommand(collection));
        manager.getCommands().put("print_ascending", new PrintAscendingCommand(collection));
        manager.getCommands().put("print_field_descending_employees_count", new PrintFieldDescendingCommand(collection));

        while (manager.isProgrammState()) {
            manager.executeCommand(scanner.nextLine());
        }
    }

}
