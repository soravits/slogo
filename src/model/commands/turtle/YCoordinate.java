package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to return the y-coordinate of the current active turtle
 * @author Brian
 *
 */
public class YCoordinate extends TurtleCommand {

    public YCoordinate (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return this.getModel().getTurtle().getTurtleY();
    }

}
