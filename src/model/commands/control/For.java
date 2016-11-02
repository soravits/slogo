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
public class For extends ControlCommand{

	private String variable;
	private double start;
	private double end;
	private double increment;

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
        Double currValue = workspace.getVariableValue(variable);
        workspace.addVariable(variable, start);
        for(double i = start; i < end; i += increment){
        	for(double j = 0; j < commandRoot.getChildren().size(); j++){
        	ret = executeTree(commandRoot.getChildren().get((int)j));
        	workspace.addVariable(variable, i);
        	}
        }
        if(currValue != null){
            workspace.addVariable(variable, currValue);
        }else{
            workspace.removeVariable(variable);
        }
        return ret;
	}
}
