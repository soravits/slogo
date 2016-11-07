package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to turn the turtle left by the specified angle (in degrees)
 * @author Brian
 *
 */
public class Left extends TurtleCommand{

    public Left (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        this.getModel().getTurtle().addTurtleAngle(-normalizeAngle(this.getParams()[0]));
        return this.getParams()[0];
    }    

}
