package model.commands.control;
import controller.Node;
import controller.Parser;
import model.Model;
import model.commandabstract.ControlCommand;

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
		Node commandRoot = null;
		if(bool != 0){
			commandRoot = getRoot().getChildren().get(1);
		}else{
			commandRoot = getRoot().getChildren().get(2);
		}
		for(int j = 0; j < commandRoot.getChildren().size()-1; j++){
			parser.executeTree(commandRoot.getChildren().get(j));
		}
		if(commandRoot.getChildren().size() > 0){
			return parser.executeTree(commandRoot.getChildren().get(commandRoot.getChildren().size()-1));
		}
		return 0;
	}
}
