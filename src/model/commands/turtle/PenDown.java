package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to Set the current turtle's pen to be down; return 1;
 * @author Brian
 *
 */
public class PenDown extends TurtleCommand{

    public PenDown (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        this.getModel().getLineState().setPenDown(true);
        return 1;
    }
    
    

}
