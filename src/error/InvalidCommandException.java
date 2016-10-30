package error;

/**
 * Created by Soravit on 10/30/2016.
 */
public class InvalidCommandException extends Exception{

    public static final String ERROR_MESSAGE = " could not be executed.";
    private String commandName;

    public InvalidCommandException(String commandName){
        super();
        this.commandName = commandName;
    }

    @Override
    public String getMessage() {
        return commandName + ERROR_MESSAGE;
    }
}
