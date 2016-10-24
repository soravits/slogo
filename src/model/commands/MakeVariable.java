package model.commands;

import controller.Node;
import controller.Parser;
import model.Model;
import model.commandabstract.ControlCommand;

public class MakeVariable extends ControlCommand{

    private String name;
    
    public MakeVariable (Node root, Parser parser, Model model) {
        super(root, parser, model);
        name = getRoot().getChildren().get(0).getValue().substring(1);
    }

    @Override
    public double execute() throws Exception {
    	Node child = getRoot().getChildren().get(1);
    	getModel().getWorkspace().addVariable(name, getParser().executeTree(child));
    	return getModel().getWorkspace().getVariableValue(name);
    }

    
}
