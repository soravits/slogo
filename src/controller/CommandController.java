package controller;

import java.util.Stack;

import error.InvalidCommandException;
import error.InvalidSyntaxException;
import model.abstractcommands.Command;

public class CommandController {

    private Stack<Command> commands;
    private Command currentCommand;
    
    public CommandController(){
        commands = new Stack<Command>();
    }
    
    public void setCommand(Command command){
        currentCommand = command;
        commands.add(command);
    }
    
    public double execute() throws Exception{
        return currentCommand.execute();
    }
}
