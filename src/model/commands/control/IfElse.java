package model.commands.control;
import controller.Node;
import controller.Parser;
import model.Model;
import model.commands.ControlCommand;

/**
 * Created by Soravit on 10/23/2016.
 */
public class IfElse extends ControlCommand{

	double bool;
	Parser parser;

	public IfElse(Node root, Parser parser, Model model) throws Exception{
		super(root,model);
		this.parser = parser;
		bool = parser.executeTree(root.getChildren().get(0));
	}

	@Override
	public double execute() throws Exception {
		if(bool == 1){
			for(int j = 1; j < getRoot().getChildren().size(); j++){
				if(j != getRoot().getChildren().size()-1){
					parser.executeTree(getRoot().getChildren().get(j));
				}
			}
			return parser.executeTree(getRoot().getChildren().get(getRoot().getChildren().size()-1));
		}
		return 0;
	}
}
