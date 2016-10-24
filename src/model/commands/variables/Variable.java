package model.commands.variables;

import model.Model;
import model.WorkspaceState;
import model.commands.Command;

public class Variable extends Command{

    private String variableName;
    public Variable (String varName, Model model) {
        super(model);
        variableName = varName;
    }

    @Override
    public double execute() {
        WorkspaceState workspace = this.getModel().getWorkspace();
        if(workspace.getListOfVariables().get(variableName) != null){
        	workspace.addVariable(variableName, 0.0);
        	return 0;
        }else{
        	return workspace.getListOfVariables().get(variableName);
        }
    }

}
