package error;

/**
 * Created by Soravit on 10/30/2016.
 */
public class InvalidSyntaxException extends Exception{

    public static final String ERROR_MESSAGE = " is invalid syntax.";
    private String invalidSyntax;

    public InvalidSyntaxException(String syntax){
        super();
        this.invalidSyntax = syntax;
    }

    @Override
    public String getMessage() {
        return invalidSyntax + ERROR_MESSAGE;
    }
}
