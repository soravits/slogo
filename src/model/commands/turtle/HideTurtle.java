package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command that tells current Turtle to no longer be showing; returns 0
 * @author Brian
 *
 */
public class HideTurtle extends TurtleCommand{

    public HideTurtle (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        this.getModel().getTurtle().setShowTurtle(false);
        return 1;
    }
    
}
