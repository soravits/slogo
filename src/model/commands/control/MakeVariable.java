package model.commands.control;

import controller.CommandManager;
import controller.Node;
import controller.Interpreter;
import model.Model;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

/**
 * This class implement the MakeVariable command that creates a new variables or modifies an existing variable
 * to a specified value.
 * @author Soravit Sophastienphong
 */
public class MakeVariable extends ControlCommand{

    private String name;

    /**
     * Executes the command represented by the expression tree rooted at this control structure command.
     * @param root The root of the tree.
     * @return The double returned by the command.
     * @throws Exception If any error occurs as a result of the execution of the command.
     */
    public MakeVariable (Node root, CommandManager commandManager, ControlCommandInterface model) {
        super(root, commandManager, model);
        //System.out.println("Hello");
        name = getRoot().getChildren().get(0).getValue();
    }

    @Override
    public double execute() throws Exception {
    	Node child = getRoot().getChildren().get(1);
    	getModel().getWorkspace().addVariable(name, executeTree(child));
    	return getModel().getWorkspace().getVariableValue(name);
    }

    
}
