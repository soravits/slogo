package model.abstractcommands;

import controller.CommandManager;
import controller.Node;
import model.Model;
import model.interfaces.ControlCommandInterface;

/**
 * Created by Soravit on 10/23/2016.
 */
public abstract class ControlCommand implements CommandInterface {

    private ControlCommandInterface controlCommand;
    private Node root;
    private CommandManager commandManager;

    public ControlCommand(Node root, CommandManager commandManager, ControlCommandInterface model){
        controlCommand = model;
        this.root = root;
        this.commandManager = commandManager;
    }
    
    public ControlCommandInterface getModel(){
        return controlCommand;
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
