package model;

/**
 * Every specified command has its own class. Each class will have a special operation that it will
 * perform, but the implementation of the specific operations are hidden in the execute() method
 * specified in this interface. All Command classes implement this basic interface
 * @author Brian
 *
 */
public interface CommandInterface {

    /*
     * Perform the given operation needed depending on the command specified by the Interpreter
     */
    public void execute();
}
