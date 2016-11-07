package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to Return the ID of the current turtle in the Turtle Map
 * @author Brian
 *
 */
public class ID extends TurtleCommand{

    public ID (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return this.getModel().getID();
    }
}
