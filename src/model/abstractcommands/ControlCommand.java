package model.abstractcommands;

import controller.CommandController;
import controller.CommandManager;
import controller.Node;
import controller.Interpreter;
import error.InvalidCommandException;
import model.Model;

/**
 * Created by Soravit on 10/23/2016.
 */
public abstract class ControlCommand extends Command {

    private Node root;
    private CommandManager commandManager;

    public ControlCommand(Node root, CommandManager commandManager, Model model){
        super(model);
        this.root = root;
        this.commandManager = commandManager;
    }
    
    public Node getRoot(){
    	return root;
    }
    
    public double executeTree(Node root) throws Exception {
        return commandManager.executeTree(root);
    }

    public void addInstruction(String name, Node root){
        commandManager.addInstruction(name, root);
    }
}
