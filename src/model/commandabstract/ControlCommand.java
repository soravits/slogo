package model.commandabstract;

import controller.Node;
import model.Model;

/**
 * Created by Soravit on 10/23/2016.
 */
public abstract class ControlCommand extends Command {

    private Node root;

    public ControlCommand(Node root, Model model){
        super(model);
        this.root = root;
    }
    
    public Node getRoot(){
    	return root;
    }
}
