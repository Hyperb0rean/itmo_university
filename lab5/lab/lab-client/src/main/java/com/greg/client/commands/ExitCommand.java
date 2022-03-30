package com.greg.client.commands;

import com.greg.client.util.CommandManager;

public class ExitCommand extends Command{


    private final CommandManager target;

    public ExitCommand(CommandManager target) {
        super("exit", "Завершить программу (без сохранения в файл)");
        this.target = target;
    }

    public CommandManager getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        target.setProgrammState(false);
        return true;
    }
}
