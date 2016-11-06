package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return a constant as itself
 * @author Brian
 *
 */
public class Constant extends MathBoolCommand {

    public Constant (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return this.getParams()[0];
    }

}
