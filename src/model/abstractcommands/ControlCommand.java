package model.abstractcommands;

import controller.CommandManager;
import controller.Node;
import model.Model;
import model.interfaces.WorkspaceCommandInterface;

/**
 * Created by Soravit on 10/23/2016.
 */
public abstract class ControlCommand implements CommandInterface {

    private WorkspaceCommandInterface workspace;
    private Node root;
    private CommandManager commandManager;

    public ControlCommand(Node root, CommandManager commandManager, Model model){
        workspace = model;
        this.root = root;
        this.commandManager = commandManager;
    }
    
    public WorkspaceCommandInterface getModel(){
        return workspace;
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
