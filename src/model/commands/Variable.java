package model.commands;

import model.Model;
import model.WorkspaceState;
import model.abstractcommands.Command;

public class Variable extends Command{

    private String variableName;
    public Variable (String varName, Model model) {
        super(model);
        variableName = varName;
    }

    @Override
    public double execute() {
        WorkspaceState workspace = this.getModel().getWorkspace();
        if(!workspace.getListOfVariables().containsKey(variableName)){
        workspace.addVariable(variableName, 0.0);
        }
        return workspace.getVariableValue(variableName);
    }
}
