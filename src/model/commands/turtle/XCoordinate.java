package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to return the X-coordinate of the current active turtle
 * @author Brian
 *
 */
public class XCoordinate extends TurtleCommand {

    public XCoordinate (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return this.getModel().getTurtle().getTurtleX();
    }

}
