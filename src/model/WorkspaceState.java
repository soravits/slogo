package model;

import java.util.HashMap;

public class WorkspaceState {
    
    private HashMap<String, Double> mapOfVariables;
    
    public WorkspaceState(){
        mapOfVariables = new HashMap<String, Double>();
    }

    public void addVariable (Object name, Double value) {
        if (mapOfVariables.containsKey(name)){
            mapOfVariables.replace(name.toString(), value);
        }else{
        	mapOfVariables.put(name.toString(), value);
        }
    }

    public void removeVariable (Object var) {
        mapOfVariables.remove(var);
    }
    
    public double getVariableValue(String name){
        return mapOfVariables.get(name);
    }
   

    public HashMap<String, Double> getListOfVariables () {
        return mapOfVariables;
    }

    public void clearWorkspace () {
        mapOfVariables = new HashMap<String, Double>();
    }
    
}
