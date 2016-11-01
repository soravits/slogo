package model.commands.control;
import controller.CommandManager;
import controller.Node;
import controller.Interpreter;
import model.Model;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

/**
 * Created by Soravit on 10/23/2016.
 */
public class If extends ControlCommand{

	double bool;

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
