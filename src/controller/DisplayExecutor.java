package controller;

import error.InvalidCommandException;
import model.Model;
import model.interfaces.DisplayCommandInterface;

/**
 * Created by Soravit on 11/2/2016.
 */
public class DisplayExecutor extends Executor {

    public static final String DISPLAY_COMMAND_PACKAGE = "model.commands.display.";
    

    @Override
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException {
        setPackage(DISPLAY_COMMAND_PACKAGE);
        setCommandInterface(DisplayCommandInterface.class);
        return super.execute(root, commandManager, model);
    }

}
