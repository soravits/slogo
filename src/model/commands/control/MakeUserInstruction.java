package model.commands.control;
import controller.CommandManager;
import controller.Node;
import controller.Interpreter;
import model.Model;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

/**
 * This class implements the MakeUserInstruction commands that takes a set of parameters and commands to define
 * a new command.
 * @author Soravit Sophastienphong
 */
public class MakeUserInstruction extends ControlCommand{

	String commandName;

	/**
	 * Executes the command represented by the expression tree rooted at this control structure command.
	 * @param root The root of the tree.
	 * @return The double returned by the command.
	 * @throws Exception If any error occurs as a result of the execution of the command.
	 */
	public MakeUserInstruction(Node root, CommandManager commandManager, ControlCommandInterface model) throws Exception{
		super(root,commandManager,model);
	}

	@Override
	public double execute() {
		try{
			commandName = getRoot().getChildren().get(0).getValue();
			addInstruction(commandName, getRoot());
			return 1;
		}catch(Exception e){
			return 0;
		}
	}
}
