/**
 * The purpose of this class is to take the string from the controller, translate it from the specified language
 * to english, and create an expresion tree to be sent to the interpreter.
 *
 * @author Soravit
 */
public interface Parser {

    /**
     * Checks the spacing of the string, calls translateString(), and calls createExpressionTree()
     * @param s The unparsed user input string
     */
    public void parseString(String s);

    /**
     * Changes the language of the parser such that it knows what to translate it from to English
     * @param language The name of the language of the user input
     */
    public void changeLanguage(String language);

    /**
     * @return The root of the most recently created expression tree
     */
    public Node getTreeRoot();

    /**
     * Translates the string to English
     * @param s The untranslated string
     */
    private void translateString(String s);

    /**
     * Creates an expression tree to represent the command and its inputs if they exist
     * @param s The translated string
     */
    private void createExpressionTree(String s);





}
