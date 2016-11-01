package model.commands.control;

import controller.CommandManager;
import controller.Node;

import controller.Interpreter;
import model.Model;
import model.abstractcommands.ControlCommand;

/**
 * Created by Soravit on 10/23/2016.
 */
public class Repeat extends ControlCommand{

	double count;

	public Repeat(Node root, CommandManager commandManager, Model model) throws Exception{
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
