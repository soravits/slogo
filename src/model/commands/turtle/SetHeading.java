package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to Set the turtle's absolute angle to the specified degree; return the change in angle
 * @author Brian
 *
 */
public class SetHeading extends TurtleCommand{

    public SetHeading (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        double currentAngle = this.getModel().getTurtle().getTurtleAngle();
        this.getModel().getTurtle().setTurtleAngle(normalizeAngle(this.getParams()[0]));
        return this.getParams()[0] - currentAngle;
    }

    
}
