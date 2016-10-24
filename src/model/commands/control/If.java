package model.commands.control;
import controller.Node;
import controller.Parser;
import model.Model;
import model.commands.ControlCommand;

/**
 * Created by Soravit on 10/23/2016.
 */
public class If extends ControlCommand{

	double bool;

	public If(Node root, Parser parser, Model model) throws Exception{
		super(root,parser,model);
		bool = getParser().executeTree(root.getChildren().get(0));
	}

	@Override
	public double execute() throws Exception {
		if(bool != 0 && getRoot().getChildren().get(1).getChildren().size() > 0){
			Node commandRoot = getRoot().getChildren().get(1);
			for(int j = 0; j < commandRoot.getChildren().size()-1; j++){
					getParser().executeTree(commandRoot.getChildren().get(j));
			}
			return getParser().executeTree(commandRoot.getChildren().get(getRoot().getChildren().size() - 1));
		}
		return 0;
	}
}
