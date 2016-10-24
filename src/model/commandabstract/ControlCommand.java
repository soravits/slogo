package model.commandabstract;

import controller.Node;
import controller.Parser;
import model.Model;

/**
 * Created by Soravit on 10/23/2016.
 */
public abstract class ControlCommand extends Command {

    private Node root;
    private Parser parser;

    public ControlCommand(Node root, Parser parser, Model model){
        super(model);
        this.root = root;
        this.parser = parser;
    }
    
    public Node getRoot(){
    	return root;
    }
    
    public Parser getParser(){
    	return parser;
    }
}
