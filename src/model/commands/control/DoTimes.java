package model.commands.control;
import controller.CommandManager;
import controller.Node;
import controller.Interpreter;
import model.Model;
import model.WorkspaceState;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

/**
 * This class implements the DoTimes command that repeats a set of commands for each value specified in a range
 * from 1 to a specified limit.
 * @author Soravit Sophastienphong
 */
public class DoTimes extends ControlCommand{

    private String variable;
    private double limit;

    /**
     * Executes the command represented by the expression tree rooted at this control structure command.
     * @param root The root of the tree.
     * @return The double returned by the command.
     * @throws Exception If any error occurs as a result of the execution of the command.
     */
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
        }
        else{
            workspace.removeVariable(variable);
        }
        return ret;
    }
}
