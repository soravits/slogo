package model.commands.control;

import controller.CommandManager;
import controller.Node;
import model.Model;
import model.abstractcommands.ControlCommand;

public class Tell extends ControlCommand {

    public Tell(Node root, CommandManager commandManager, Model model) {
        super(root, commandManager, model);
    }

    @Override
    public double execute() throws Exception {
        Node commandsRoot = getRoot().getChildren().get(1);
        double ret = 0;
        for(int i = 0; i < commandsRoot.getChildren().size(); i++){
            ret = Double.parseDouble(commandsRoot.getChildren().get(i).getValue());
        }
        return ret;
    }
}
