package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to turn the turtle to the right by the specified number of degrees; returns the number of degrees turned
 * @author Brian
 *
 */
public class Right extends TurtleCommand{

    public Right (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        this.getModel().getTurtle().addTurtleAngle(normalizeAngle(this.getParams()[0]));
        return this.getParams()[0];
    }
    
}
