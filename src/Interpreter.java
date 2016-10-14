/**
 * The purpose of this class is to take the expression trees created by the parser and call the corresponding
 * classes or methods to those commands using reflection.
 *
 * @author Soravit
 */
public interface Parser {

    /**
     * @param n The root of the expression tree representing the command
     */
    public void interpretCommand(Node n);

    /**
     * Instantiates the class that corrsponds to the command by using its children as inputs
     * @param n The node representing the command to be instantiated as a class
     */
    private void createInstanceOfClass(Node n);

    /**
     * Empties the queue
     */
    private void clearQueue();
}
