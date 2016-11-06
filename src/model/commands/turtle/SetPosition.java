package model.commands.turtle;

import model.TurtleState;
import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to set the turtle's position to an absolute (x, y) position. Return the distance moved
 * @author Brian
 *
 */
public class SetPosition extends TurtleCommand{

    public SetPosition (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        TurtleState turtle = getModel().getTurtle();
        double dist = turtle.getPosition().clone().distance(this.getParams()[0], this.getParams()[1]);
        turtle.setTurtlePosition(this.getParams()[0], this.getParams()[1]);
        return dist;
    }

}
