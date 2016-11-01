package model.commands.control;
import controller.CommandManager;
import controller.Node;
import controller.Interpreter;
import model.Model;
import model.abstractcommands.ControlCommand;

/**
 * Created by Soravit on 10/23/2016.
 */
public class IfElse extends ControlCommand{

	double bool;

	public IfElse(Node root, CommandManager commandManager, Model model) throws Exception{
		super(root, commandManager, model);
		bool = executeTree(root.getChildren().get(0));
	}

	@Override
	public double execute() throws Exception {
		Node commandRoot = null;
		double ret = 0;
		if(bool != 0){
			commandRoot = getRoot().getChildren().get(1);
		}else{
			commandRoot = getRoot().getChildren().get(2);
		}
		for(int j = 0; j < commandRoot.getChildren().size(); j++){
			ret = executeTree(commandRoot.getChildren().get(j));
		}
		if(commandRoot.getChildren().size() > 0){
			return ret;
		}
		return 0;
	}
}
