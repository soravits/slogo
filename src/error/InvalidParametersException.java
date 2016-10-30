package error;

/**
 * Created by Soravit on 10/30/2016.
 */
public class InvalidParametersException extends Exception{

    public static final String ERROR_MESSAGE_BEGINNING = "The command : ";
    public static final String ERROR_MESSAGE_END = " has invalid parameters";

    private String commandName;

    public InvalidParametersException(String commandName){
        super();
        this.commandName = commandName;
    }

    @Override
    public String getMessage() {
        return ERROR_MESSAGE_BEGINNING + commandName + ERROR_MESSAGE_END;
    }
}
