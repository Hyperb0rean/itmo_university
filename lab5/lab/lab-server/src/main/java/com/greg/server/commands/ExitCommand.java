package com.greg.server.commands;

import com.greg.server.util.ServerCommandManager;

public class ExitCommand extends Command{


    public ExitCommand(ServerCommandManager manager) {
        super("exit", "Завершить программу (без сохранения в файл)",manager);
    }

    @Override
    public boolean execute(String argument) {
        this.getManager().setProgramState(false);
        return true;
    }
}
