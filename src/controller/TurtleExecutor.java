package controller;

import error.InvalidCommandException;
import model.Model;

/**
 * Created by Soravit on 10/31/2016.
 */

public class TurtleExecutor extends Executor{

    public static final String TURTLE_COMMAND_PACKAGE = "model.commands.turtle.";

    @Override
    public double execute(Node root, CommandManager executor, Model model) throws InvalidCommandException {
        setPackage(TURTLE_COMMAND_PACKAGE);
        if(root.getIsFoundTurtleCommand() == false) {
            root.setFoundTurtleCommand(true);
        }
        return super.execute(root, executor, model);
    }
}
