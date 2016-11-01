package model.commands.control;

import controller.CommandManager;
import controller.Node;
import model.Model;
import model.abstractcommands.ControlCommand;

/**
 * Created by Soravit on 10/31/2016.
 */
public class Ask extends ControlCommand{
    
    public Ask(Node root, CommandManager commandManager, Model model) {
        super(root, commandManager, model);
    }

    @Override
    public double execute() throws Exception {
        return 0;
    }
}
