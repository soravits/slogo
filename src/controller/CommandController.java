package controller;

import java.util.Stack;
import model.abstractcommands.CommandInterface;

/**
 * This is Command Controller as specifed in the Command design pattern. Every command, regardless of type, is
 * passed to the instance of this class in the Controller. Each command is stored in a stack to be used for
 * undo-ing commands (we never got to implement this feature, but it the commands were stored here for future
 * implementation if we had more time). From here, the current command is executed to update the model and
 * the output is returned
 * @author Brian
 *
 */
public class CommandController {

    private Stack<CommandInterface> commands;
    private CommandInterface currentCommand;
    
    public CommandController(){
        commands = new Stack<CommandInterface>();
    }
    
    
    public void setCommand(CommandInterface command) {
        currentCommand = command;
        commands.add(command);
    }
    /**
     * Add the command to the stack of command; useful for undoing commands if needed.
     * Executes the command, which updates the model and returns the needed output
     * @param command : the specific command to be executed next based on the Execution Tree
     * @return the double associated with the command's output
     * @throws Exception for a variety of reasons (divide by zero, tan of 90, etc)
     */
    public double executeCommand() throws Exception{
        return currentCommand.execute();
    }
}
