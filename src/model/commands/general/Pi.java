package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return the number Pi (3.1415926535)
 * @author Brian
 *
 */
public class Pi extends MathBoolCommand{

    public Pi (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return Math.PI;
    }

}
