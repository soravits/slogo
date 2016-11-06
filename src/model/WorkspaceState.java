package model;

import java.util.AbstractMap;
import java.util.HashMap;

/**
 * Stores and manipulates the current workspace of variables. Currently implemented using a HashMap to
 * map keys to values
 * @author Brian
 *
 */
public class WorkspaceState {
    
    private HashMap<String, Double> mapOfVariables;
    
    public WorkspaceState(){
        mapOfVariables = new HashMap<String, Double>();
    }

    /**
     * Add a variable of with string 'name' and double 'value' to the workspace of variables
     * @param name
     * @param value
     */
    public void addVariable (Object name, Double value) {
        if (mapOfVariables.containsKey(name)){
            mapOfVariables.replace(name.toString(), value);
        }else{
            mapOfVariables.put(name.toString(), value);
        }
    }

    /**
     * Remove variable with name from the workspace 
     * @param name
     */
    public void removeVariable(Object name){
        mapOfVariables.remove(name);
    }

    /**
     * get the value of the variable
     * @param name
     * @return value of the variable associated with its name
     */
    public double getVariableValue(String name){
        return mapOfVariables.get(name);
    }

    /**
     * 
     * @param name
     * @return true if the variable name exists in the current workspace
     */
    public boolean variableExists(String name){
        return mapOfVariables.containsKey(name);
    }
   
    /**
     * 
     * @return workspace of variables
     */
    public AbstractMap<String, Double> getListOfVariables () {
        return mapOfVariables;
    }

    /**
     * Clear the current workspace of variables
     */
    public void clear() {
        mapOfVariables.clear();
    }
    
}
