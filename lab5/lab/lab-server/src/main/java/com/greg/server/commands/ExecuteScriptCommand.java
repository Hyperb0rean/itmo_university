package com.greg.server.commands;

import com.greg.server.exceptions.IllegalArgumentException;
import com.greg.server.exceptions.RecursionDepthExceededException;
import com.greg.server.util.io.RequestInput;
import com.greg.server.util.ServerCommandManager;
import com.greg.server.util.io.FileInput;

import java.io.*;
import java.util.Scanner;

public class ExecuteScriptCommand extends Command{

    public ExecuteScriptCommand(ServerCommandManager manager) {
        super("execute_script", "читать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.",manager);
    }

    @Override
    public boolean execute(String argument) {
        try{
            if(!argument.isEmpty()){

                File file = new File(argument);
                FileReader fr = new FileReader(file);
                this.getManager().setInput(new FileInput(fr));
                Scanner scanner = this.getManager().getInput().getScanner();

                while (scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    if(line.split(" ")[0].equals("execute_script")) throw new RecursionDepthExceededException("Превышена глубина рекурсии команды execute_script");
                    this.getManager().executeCommand(line);
                }
                fr.close();
                this.getManager().setInput(new RequestInput(1337,getManager()));
                return true;
            }
            else throw new IllegalArgumentException("Необходимо передать файл в качестве аргумента команды");
        } catch (IllegalArgumentException | IOException | RecursionDepthExceededException e) {

            this.getManager().getOutput().error(e.getMessage());
            return false;
        }
    }
}
