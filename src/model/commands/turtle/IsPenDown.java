package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to return 1 if the current turtle's pen is down; 0 otherwise
 * @author Brian
 *
 */
public class IsPenDown extends TurtleCommand{

    public IsPenDown (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return (getModel().getLineState().isPenDown()) ? 1 : 0;
    }

}