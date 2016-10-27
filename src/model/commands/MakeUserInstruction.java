package model.commands;
import controller.Node;
import controller.Interpreter;
import model.Model;
import model.abstractcommands.ControlCommand;

/**
 * Created by Soravit on 10/23/2016.
 */
public class MakeUserInstruction extends ControlCommand{

	String commandName;
	
	public MakeUserInstruction(Node root, Interpreter parser, Model model) throws Exception{
		super(root,parser,model);		
	}

	@Override
	public double execute() {
		try{
			if(getRoot().getChildren().size() == 3 && getParser().isValidCommandName(getRoot().getChildren().get(0).getValue())){
				commandName = getRoot().getChildren().get(0).getValue();
			}else{
				return 0;
			}
			getParser().addInstruction(commandName, getRoot());
			return 1;
		}catch(Exception e){
			return 0;
		}
	}
}
