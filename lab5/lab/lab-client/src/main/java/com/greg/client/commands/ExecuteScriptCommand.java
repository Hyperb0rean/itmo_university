package com.greg.client.commands;

import com.greg.client.exceptions.IllegalArgumentException;
import com.greg.client.exceptions.RecursionDepthExceededException;
import com.greg.client.util.CommandManager;

import java.io.*;
import java.util.Scanner;

public class ExecuteScriptCommand extends Command{

    private final CommandManager target;

    public ExecuteScriptCommand(CommandManager target) {
        super("execute_script", "читать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        this.target = target;
    }

    public CommandManager getTarget() {
        return target;
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(!argument.isEmpty()){

                File file = new File(argument);
                FileReader fr = new FileReader(file);
                Scanner scanner = new Scanner(fr);

                while (scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    if(line.equals("execute_script " + argument)){
                        target.setRecursionDepth(target.getRecursionDepth() +1);
                        if (target.getRecursionDepth()>4) throw new RecursionDepthExceededException("Превышена глубина рекурсии команды execute_script");
                    }
                    target.executeCommand(line);
                }
                fr.close();

                return true;
            }
            else throw new IllegalArgumentException("Необходимо передать файл в качестве аргумента команды");
        } catch (IllegalArgumentException | IOException | RecursionDepthExceededException e) {

            System.err.println(e.getMessage());
            return false;
        }
        finally {
            target.setRecursionDepth(0);
        }
    }
}
