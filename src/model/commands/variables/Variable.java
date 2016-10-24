package model.commands.variables;

import model.Model;
import model.WorkspaceState;
import model.commandabstract.Command;

public class Variable extends Command{

    private String variableName;
    public Variable (String varName, Model model) {
        super(model);
        variableName = varName;
    }

    @Override
    public double execute() {
        WorkspaceState workspace = this.getModel().getWorkspace();
        workspace.addVariable(variableName, 0.0);
        return workspace.getVariableValue(variableName);
    }
}
