package model.commands.control;
import controller.CommandManager;
import controller.Node;
import controller.Interpreter;
import model.Model;
import model.WorkspaceState;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

/**
 * This class implements the For command that repeats a set of commands for each value in the specified range from
 * one value incremented by a certain increment to another value.
 * @author Soravit Sophastienphong
 */
public class For extends ControlCommand{

	private String variable;
	private double start;
	private double end;
	private double increment;

	/**
	 * Executes the command represented by the expression tree rooted at this control structure command.
	 * @param root The root of the tree.
	 * @return The double returned by the command.
	 * @throws Exception If any error occurs as a result of the execution of the command.
	 */
	public For(Node root, CommandManager commandManager, ControlCommandInterface model) throws Exception{
		super(root,commandManager,model);
		Node commandRoot = getRoot().getChildren().get(0);
		variable = commandRoot.getChildren().get(0).getValue();
		start = executeTree(commandRoot.getChildren().get(1));
		end = executeTree(commandRoot.getChildren().get(2));
		increment = executeTree(commandRoot.getChildren().get(3));
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
        workspace.addVariable(variable, start);
        for(double i = start; i < end; i += increment){
        	for(double j = 0; j < commandRoot.getChildren().size(); j++){
        	ret = executeTree(commandRoot.getChildren().get((int)j));
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
