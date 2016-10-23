package model.commands.control;

import controller.Node;
import controller.Parser;
import model.Model;
import model.commands.ControlCommand;

/**
 * Created by Soravit on 10/23/2016.
 */
public class Repeat extends ControlCommand{

	double count;
	Parser parser;

	public Repeat(Node root, Parser parser, Model model) throws Exception{
		super(root,model);
		this.parser = parser;
		count = parser.executeTree(root.getChildren().get(0));
	}

	@Override
	public double execute() throws Exception {
		Node commandsRoot = getRoot().getChildren().get(1);
		for(int i = 0; i < count; i++){
			for(int j = 1; j < commandsRoot.getChildren().size(); j++){
				if(j != commandsRoot.getChildren().size()-1){
					parser.executeTree(commandsRoot.getChildren().get(j));
				}
			}
		}
		return parser.executeTree(getRoot().getChildren().get(getRoot().getChildren().size()-1));
	}
}
