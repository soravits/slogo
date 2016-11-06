package controller;

import error.InvalidCommandException;
import model.Model;
import model.interfaces.DisplayCommandInterface;

/**
 * This class is responsible for executing display commands.
 * @author Soravit Sophastienphong
 */
public class DisplayExecutor extends Executor {

    public static final String DISPLAY_COMMAND_PACKAGE = "model.commands.display.";

    /**
     * @param root The root of the expression tree of the command being executed.
     * @param commandManager A reference to a CommandManager object from which data can be obtained about command types.
     * @param model A reference to the current model.
     * @return The double returned by the execution of the root.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     */
    @Override
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException {
        setPackage(DISPLAY_COMMAND_PACKAGE);
        setCommandInterface(DisplayCommandInterface.class);
        return super.execute(root, commandManager, model);
    }

}
