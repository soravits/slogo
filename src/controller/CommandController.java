// This entire file is part of my masterpiece
// Brian Keohane


/* This class serves as the Invoker in the Command Design Pattern implemented to handle dealing with basic
 commands. The Command Manager has an instance of this CommandController, and after successfully parsing
 an input and determining a command to run via reflection, the Command manager passes the command to 
 this controller and lets this class/the Command hierarchy do the work. 
 
 This class features good design principles in a variety of ways. First, it is extremely flexible in that 
 you can pass any class that implements the CommandInterface to this controller to be stored and executed.
 Operating directly on the interface eliminates the need for the Command Controller to know the inner workings
 of any of the Command classes; all it has to do is call command.execute() and it can trust that a command
 will be run. It decouples the command classes from the controller.
 
 Another reason that this class is well designed is the easy ability to implement the 'undo' feature for the
 project. I did not do this due to a lack of time (I spent way more time than expected helping to debug other
 people's code), but undoing performed commands would involve making a few simple additions. 
 All that would need to be done is add a method public void undo() to the command interface.
 Then this controller could pop the command interfaces off the stack one by one and simply call the undo()
 method associated with each command. 
 
 This class is very short and easy to understand in terms of implementation (and there doesn't appear to be
 repeated code or anything as obviously smelly). 
*/
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
    
    public CommandController(){
        commands = new Stack<CommandInterface>();
    }
    
    /**
     * Add the command to the stack of command; useful for undoing commands if needed.
     * Executes the command, which updates the model and returns the needed output
     * @param command : the specific command to be executed next based on the Execution Tree
     * @return the double associated with the command's output
     * @throws Exception for a variety of reasons (divide by zero, tan of 90, etc)
     */
    public double executeCommand(CommandInterface command) throws Exception{
        commands.add(command);
        return command.execute();
    }
}
