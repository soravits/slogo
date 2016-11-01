package model.commands.control;

import controller.CommandManager;
import controller.Node;
import model.Model;
import model.abstractcommands.ControlCommand;
import model.interfaces.ControlCommandInterface;

import javax.sound.sampled.Control;

/**
 * Created by Soravit on 10/31/2016.
 */
public class AskWith extends ControlCommand {

    public AskWith(Node root, CommandManager commandManager, ControlCommandInterface model) {
        super(root, commandManager, model);
    }

    @Override
    public double execute() throws Exception {
        return 0;
    }
}
