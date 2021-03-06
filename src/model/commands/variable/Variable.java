package model.commands.variable;

import model.WorkspaceState;
import model.abstractcommands.CommandInterface;
import model.interfaces.ControlCommandInterface;

/**
 * return the value associated with a variable name
 * @author Brian
 *
 */
public class Variable implements CommandInterface{

    private String variableName;
    private ControlCommandInterface listOfVars;

    public Variable (String varName, ControlCommandInterface model) {
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
