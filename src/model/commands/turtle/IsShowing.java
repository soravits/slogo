package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to Return 1 if the current Turtle is Showing; 0 otherwise
 * @author Brian
 *
 */
public class IsShowing extends TurtleCommand {

    public IsShowing (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return (getModel().getTurtle().getShowTurtle()) ? 1 : 0;
    }

}
