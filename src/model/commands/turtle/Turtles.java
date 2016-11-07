package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to return the number of turtles currently used in the workspace
 * @author Brian
 *
 */
public class Turtles extends TurtleCommand{

    public Turtles (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return this.getModel().getNumberOfTurtles();
    }

}
