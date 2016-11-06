package model.commands.control;
import controller.CommandManager;
import controller.Node;
import controller.Interpreter;
import model.Model;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

/**
 * This class implements the If command that runs a set of commands based on whether an expression returns a value
 * not equal to 0.
 * @author Soravit Sophastienphong
 */
public class If extends ControlCommand{

	double bool;

	/**
	 * Executes the command represented by the expression tree rooted at this control structure command.
	 * @param root The root of the tree.
	 * @return The double returned by the command.
	 * @throws Exception If any error occurs as a result of the execution of the command.
	 */
	public If(Node root, CommandManager commandManager, ControlCommandInterface model) throws Exception{
		super(root,commandManager,model);
		bool = executeTree(root.getChildren().get(0));
	}

	@Override
	public double execute() throws Exception {
		double ret = 0;
		if(bool != 0 && getRoot().getChildren().get(1).getChildren().size() > 0){
			Node commandRoot = getRoot().getChildren().get(1);
			for(int j = 0; j < commandRoot.getChildren().size(); j++){
					ret = executeTree(commandRoot.getChildren().get(j));
			}
			return ret;
		}
		return 0;
	}
}
