package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to set the turtle to be showing; returns 1
 * @author Brian
 *
 */
public class ShowTurtle extends TurtleCommand{

    public ShowTurtle (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        getModel().getTurtle().setShowTurtle(true);
        return 1;
    }
    
}
