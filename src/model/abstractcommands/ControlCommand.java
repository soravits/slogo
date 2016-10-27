package model.abstractcommands;

import controller.Node;
import controller.Interpreter;
import model.Model;

/**
 * Created by Soravit on 10/23/2016.
 */
public abstract class ControlCommand extends Command {

    private Node root;
    private Interpreter parser;

    public ControlCommand(Node root, Interpreter parser, Model model){
        super(model);
        this.root = root;
        this.parser = parser;
    }
    
    public Node getRoot(){
    	return root;
    }
    
    public Interpreter getParser(){
    	return parser;
    }
}
