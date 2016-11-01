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
public class MakeUserInstruction extends ControlCommand{

	String commandName;
	
	public MakeUserInstruction(Node root, CommandManager commandManager, ControlCommandInterface model) throws Exception{
		super(root,commandManager,model);
	}

	@Override
	public double execute() {
		try{
			if(getRoot().getChildren().size() == 3){
				commandName = getRoot().getChildren().get(0).getValue();
			}else{
				return 0;
			}
			addInstruction(commandName, getRoot());
			return 1;
		}catch(Exception e){
			return 0;
		}
	}
}
