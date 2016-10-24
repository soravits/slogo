package controller;

import java.util.Stack;
import model.commandabstract.Command;

public class CommandController {

    private Stack<Command> commands;
    private Command currentCommand;
    
    public CommandController(){
        commands = new Stack<Command>();
    }
    
    public void setCommand(Object command){
        currentCommand = (Command) command;
        commands.add((Command) command);
    }
    
    public double execute() throws Exception{
        return currentCommand.execute();
    }
}
