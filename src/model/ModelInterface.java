package model;
/**
 * This interface specifies the public methods used to get and set all of the states in the model; 
 * these methods are called via myModel.getX() in the View class. 
 * @author Brian
 *
 */
public interface ModelInterface {
    
    /*
     * Return the current state of the Turtle to the View
     */
    public Object getTurtleState();
    
    /*
     * Return the current state of the Line to the View
     */
    public Object getLineState();
    
    /*
     * Return the current state of the Workspace to the View
     */
    public Object getWorkspaceState();
    
    /*
     * Return the current state of the Return (for the current command) to the View
     */
    public Object getReturnState();
    
    /*
     * Return all of the previous commands
     */
    public Object getCommandHistory();
    
    /*
     * Overwrite the old turtleState with the new TurtleState
     */
    public void updateTurtleState(TurtleState turtleState);
    
    /*
     * Overwrite the old LineState with the new LineState
     */
    public void updateLineState(LineState lineState);
    
    /*
     * Overwrite the old WorkspaceState with the new WorskpaceState
     */
    public void updateWorkspaceState(WorkspaceState workState);
    
    /*
     * Overwrite the old ReturnState with the new ReturnState
     */
    public void updateReturnState(ReturnState returnState);

}
