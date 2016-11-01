package controller;

import java.util.Stack;
import model.abstractcommands.CommandInterface;

public class CommandController {

    private Stack<CommandInterface> commands;
    private CommandInterface currentCommand;
    
    public CommandController(){
        commands = new Stack<CommandInterface>();
    }
    
    public void setCommand(CommandInterface command){
        currentCommand = command;
        commands.add(command);
    }
    
    public double execute() throws Exception{
        return currentCommand.execute();
    }
}
