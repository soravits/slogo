package model.abstractcommands;

import controller.CommandManager;
import controller.Node;
import model.interfaces.ControlCommandInterface;

/**
 * This is a superclass that defines initial variables and methods to be used by specific control structure commands.
 * @author Soravit
 */
public abstract class ControlCommand implements CommandInterface {

    private ControlCommandInterface controlCommand;
    private Node root;
    private CommandManager commandManager;

    /**
     * @param root The root of the expression tree of the command being executed.
     * @param commandManager A reference to a CommandManager object from which data can be obtained about command types.
     * @param model A reference to the current model.
     */
    public ControlCommand(Node root, CommandManager commandManager, ControlCommandInterface model){
        controlCommand = model;
        this.root = root;
        this.commandManager = commandManager;
    }

    /**
     * @return An interface containing the methods needed by control structure commands.
     */
    public ControlCommandInterface getModel(){
        return controlCommand;
    }

    /**
     * @return The root of the expression tree representing the control structure command
     */
    public Node getRoot(){
    	return root;
    }

    /**
     * Executes the command represented by the expression tree rooted at this control structure command.
     * @param root The root of the tree.
     * @return The double returned by the command.
     * @throws Exception If any error occurs as a result of the execution of the command.
     */
    public double executeTree(Node root) throws Exception {
        return commandManager.executeTree(root);
    }

    /**
     * Adds a new user instruction.
     * @param name The name of the instruction.
     * @param root The root of the expression tree representing the instruction.
     */
    public void addInstruction(String name, Node root){
        commandManager.addInstruction(name, root);
    }
}
