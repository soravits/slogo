package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return 1 if the first input is greater than the second input; 0 otherwise
 * @author Brian
 *
 */
public class GreaterThan extends MathBoolCommand{

    public GreaterThan (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return (this.getParams()[0] > this.getParams()[1]) ? 1 : 0;
    }

}
