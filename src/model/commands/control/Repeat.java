package model.commands.control;

import controller.CommandManager;
import controller.Node;

import controller.Interpreter;
import model.Model;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

/**
 * This class implement the Repeat command that runs a set of commands a specified number of times.
 * @author Soravit Sophastienphong
 */
public class Repeat extends ControlCommand{

	double count;

	/**
	 * Executes the command represented by the expression tree rooted at this control structure command.
	 * @param root The root of the tree.
	 * @return The double returned by the command.
	 * @throws Exception If any error occurs as a result of the execution of the command.
	 */
	public Repeat(Node root, CommandManager commandManager, ControlCommandInterface model) throws Exception{
		super(root,commandManager,model);
		count = executeTree(root.getChildren().get(0));
	}

	@Override
	public double execute() throws Exception {
		Node commandsRoot = getRoot().getChildren().get(1);
		double ret = 0;
		for(int i = 0; i < count; i++){
			for(int j = 0; j < commandsRoot.getChildren().size(); j++){
				ret = executeTree(commandsRoot.getChildren().get(j));
			}
		}
		return ret;
	}
}
