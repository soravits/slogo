package model;

/**
 * This interface outlines the public methods needed to get, add and remove new variables and expressions
 * from the workspace.
 * @author Brian
 *
 */
public interface WorkspaceStateInterface {

    /*
     * Add a variable to the list of variables contained in workspaceState
     */
    public void addVariable(Object name, Object value);
    
    /*
     * Remove a variable from the workspace
     */
    public void removeVariable(Object name);
    
    /*
     * Overwrite the value of a variable
     */
    public void overWriteVariable(Variable variable, Object value);
    
    /*
     * Return all of the workspace objects in the workspaceState
     */
    public List<Variable> getListOfVariables();
}
