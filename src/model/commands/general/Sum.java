package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to return the sum of all inputs
 * @author Brian
 *
 */
public class Sum extends MathBoolCommand{
        
    public Sum (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return sumParams();
    }
}
