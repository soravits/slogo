package model.commands.control;

import controller.Node;

import controller.Parser;
import model.Model;
import model.commandabstract.ControlCommand;

/**
 * Created by Soravit on 10/23/2016.
 */
public class Repeat extends ControlCommand{

	double count;

	public Repeat(Node root, Parser parser, Model model) throws Exception{
		super(root,parser,model);
		count = parser.executeTree(root.getChildren().get(0));
	}

	@Override
	public double execute() throws Exception {
		Node commandsRoot = getRoot().getChildren().get(1);
		double ret = 0;
		for(int i = 0; i < count; i++){
			for(int j = 0; j < commandsRoot.getChildren().size(); j++){
				ret = getParser().executeTree(commandsRoot.getChildren().get(j));
			}
		}
		return ret;
	}
}
