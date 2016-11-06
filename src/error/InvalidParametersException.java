package error;

/**
 * This is an exception representing any errors that occur from passing invalid parameters to a command.
 * @author Soravit Sophastienphong
 */
public class InvalidParametersException extends Exception{

    public static final String ERROR_MESSAGE_BEGINNING = "The command : ";
    public static final String ERROR_MESSAGE_END = " has invalid parameters";

    private String commandName;

    /**
     * @param commandName The name of the command that caused the exception.
     */
    public InvalidParametersException(String commandName){
        super();
        this.commandName = commandName;
    }

    /**
     * @return The error message to be displayed to the user when this exception is caught.
     */
    @Override
    public String getMessage() {
        return ERROR_MESSAGE_BEGINNING + commandName + ERROR_MESSAGE_END;
    }
}
