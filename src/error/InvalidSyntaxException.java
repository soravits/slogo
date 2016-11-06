package error;

/**
 * This is an exception representing any errors that occur from invalid syntax inputted by the user.
 * @author Soravit Sophastienphong
 */
public class InvalidSyntaxException extends Exception{

    public static final String ERROR_MESSAGE = " is invalid syntax.";
    private String invalidSyntax;

    /**
     * @param syntax The syntax that caused the exception.
     */
    public InvalidSyntaxException(String syntax){
        super();
        this.invalidSyntax = syntax;
    }

    /**
     * @return The error message to be displayed to the user when this exception is caught.
     */
    @Override
    public String getMessage() {
        return invalidSyntax + ERROR_MESSAGE;
    }
}
