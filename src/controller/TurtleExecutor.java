package controller;

import error.InvalidCommandException;
import model.Model;
import model.interfaces.TurtleCommandInterface;

/**
 * Created by Soravit on 10/31/2016.
 */

public class TurtleExecutor extends Executor{

    public static final String TURTLE_COMMAND_PACKAGE = "model.commands.turtle.";

    @Override
    public double execute(Node root, CommandManager executor, Model model) throws InvalidCommandException {
        setPackage(TURTLE_COMMAND_PACKAGE);
        setCommandInterface(TurtleCommandInterface.class);
        double ret = 0;
        if(!root.getIsFoundTurtleCommand()) {
            root.setFoundTurtleCommand(true);
            for(Object o : model.getTurtlesToModify()){
                model.setTurtle(o);
                ret = super.execute(root, executor, model);
            }
        }
        return ret;
    }
}
