package model;

import java.util.Collection;
import java.util.HashSet;

public class WorkspaceState implements WorkspaceStateInterface {
    
    private Collection<Variable> listOfVariables;
    
    public WorkspaceState(){
        listOfVariables = new HashSet<Variable>();
    }

    @Override
    public void addVariable (Object name, Object value) {
        Variable var = new Variable(name, value);
        if (listOfVariables.contains(var)){
            removeVariable(var);
        }
        listOfVariables.add(var);
    }

    @Override
    public void removeVariable (Object var) {
        listOfVariables.remove(var);
    }
    

    @Override
    public Collection<Variable> getListOfVariables () {
        return listOfVariables;
    }

    @Override
    public void clearWorkspace () {
        listOfVariables = new HashSet<Variable>();
    }

    
    
}
