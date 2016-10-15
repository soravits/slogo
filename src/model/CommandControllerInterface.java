package model;
/**
 * This interface specifies the way in which the command taken from the interpreter is executed
 * via a unique command class. Each command is packaged with the necessary data and variables,
 * as well as an instance of the model, and then executed via a call in the CommandController class.
 * @author Brian
 *
 */
public interface CommandControllerInterface {
    
    /**
     * Execute the command that was created by the Interpreter class
     * @param command
     */
    public void executeCommand(Command command);
    
    /**
     * Return the history of commands executed by the program
     */
    public CommandHistory getCommandHistory();

}
