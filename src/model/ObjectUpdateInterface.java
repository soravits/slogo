package model;

/**
 * Each of the different pieces of information that we must store (TurtleState, ReturnState, LineState,
 * WorkspaceState, CommandHistory, etc.) must be flexible enough to have data deleted, updated, appended
 * or overwritten upon the completion of a Command. After the command has been executed, the Model
 * values must be changed. These methods are common to each type of variable Object that needs to
 * be displayed on the GUI
 * @author Brian
 *
 */
public interface ObjectUpdateInterface {

    /**
     * Delete certain data from a specified information-storing class
     * @param o
     */
    public void delete(Object o);
    
    /**
     * Append another object to the State List (ex: append a variable to the WorkspaceStateClass
     * so that it now reflects the current values
     * @param o
     */
    public void append(Object o);
    
    /**
     * Overwrite either a value or an object currently stored in a State class
     * @param o
     */
    public void overWrite(Object o);
}
