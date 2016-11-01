package model.commands.general;

import model.Model;
import model.WorkspaceState;
import model.abstractcommands.CommandInterface;
import model.interfaces.WorkspaceCommandInterface;

public class Variable implements CommandInterface{

    private String variableName;
    private WorkspaceCommandInterface listOfVars;
    
    public Variable (String varName, Model model) {
        listOfVars = model;
        variableName = varName;
    }

    @Override
    public double execute() {
        WorkspaceState workspace = listOfVars.getWorkspace();
        if(!workspace.getListOfVariables().containsKey(variableName)){
        workspace.addVariable(variableName, 0.0);
        }
        return workspace.getVariableValue(variableName);
    }
}
