package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to Return the current angle/heading of the current Turtle
 * @author Brian
 *
 */
public class Heading extends TurtleCommand{

    public Heading (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return getModel().getTurtle().getTurtleAngle();
    }

}
