package model.commands;

import controller.CommandManager;
import controller.Node;
import controller.Interpreter;
import model.Model;
import model.abstractcommands.ControlCommand;

public class MakeVariable extends ControlCommand{

    private String name;
    
    public MakeVariable (Node root, CommandManager commandManager, Model model) {
        super(root, commandManager, model);
        name = getRoot().getChildren().get(0).getValue();
    }

    @Override
    public double execute() throws Exception {
    	Node child = getRoot().getChildren().get(1);
    	getModel().getWorkspace().addVariable(name, executeTree(child));
    	return getModel().getWorkspace().getVariableValue(name);
    }

    
}
