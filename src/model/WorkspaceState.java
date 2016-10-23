package model;

import java.util.Collection;
import java.util.HashSet;

public class WorkspaceState {
    
    private Collection<VariableObject> listOfVariables;
    
    public WorkspaceState(){
        listOfVariables = new HashSet<VariableObject>();
    }

    public void addVariable (Object name, Object value) {
        VariableObject var = new VariableObject(name, value);
        if (listOfVariables.contains(var)){
            removeVariable(var);
        }
        listOfVariables.add(var);
    }

    public void removeVariable (Object var) {
        listOfVariables.remove(var);
    }
    

    public Collection<VariableObject> getListOfVariables () {
        return listOfVariables;
    }

    public void clearWorkspace () {
        listOfVariables = new HashSet<VariableObject>();
    }

    
    
}
