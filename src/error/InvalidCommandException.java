package error;

/**
 * This is an exception representing any errors that occur during the execution of a command.
 * @author Soravit Sophastienphong
 */
public class InvalidCommandException extends Exception{

    public static final String ERROR_MESSAGE = " could not be executed.";
    private String commandName;

    /**
     * @param commandName The name of the command that caused the exception.
     */
    public InvalidCommandException(String commandName){
        super();
        this.commandName = commandName;
    }

    /**
     * @return The error message to be displayed to the user when this exception is caught.
     */
    @Override
    public String getMessage() {
        return commandName + ERROR_MESSAGE;
    }
}
