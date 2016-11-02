package model.commands.control;
import controller.CommandManager;
import controller.Node;
import controller.Interpreter;
import model.Model;
import model.WorkspaceState;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

/**
 * Created by Soravit on 10/23/2016.
 */
public class DoTimes extends ControlCommand{

    private String variable;
    private double limit;

    public DoTimes(Node root, CommandManager commandManager, ControlCommandInterface model) throws Exception{
        super(root,commandManager,model);
        Node commandRoot = getRoot().getChildren().get(0);
        variable = commandRoot.getChildren().get(0).getValue();
        limit = executeTree(commandRoot.getChildren().get(1));
    }

    @Override
    public double execute() throws Exception {
        double ret = 0;
        Node commandRoot = getRoot().getChildren().get(1);
        WorkspaceState workspace = this.getModel().getWorkspace();
        boolean exists = workspace.variableExists(variable);
        double currValue = 0;
        if(exists) {
            currValue = workspace.getVariableValue(variable);
        }
        for(double i = 1; i < limit; i++){
            for(double j = 0; j<commandRoot.getChildren().size(); j++){
                ret = executeTree(commandRoot.getChildren().get((int) j));
                workspace.addVariable(variable, i);
            }
        }
        if(exists){
            workspace.addVariable(variable, currValue);
        }else{
            workspace.removeVariable(variable);
        }
        return ret;
    }
}
