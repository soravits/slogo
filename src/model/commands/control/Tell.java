package model.commands.control;

import controller.CommandManager;
import controller.Node;
import model.Model;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

public class Tell extends ControlCommand {

    public Tell(Node root, CommandManager commandManager, ControlCommandInterface model) {
        super(root, commandManager, model);
    }

    @Override
    public double execute() throws Exception {
        Node commandsRoot = getRoot().getChildren().get(0);
        double ID = 0;
        getModel().clearTellTurtles();
        for(int i = 0; i < commandsRoot.getChildren().size(); i++){
            ID = Double.parseDouble(commandsRoot.getChildren().get(i).getValue());
            getModel().addTurtle(ID);
        }
        return ID;
    }
}
