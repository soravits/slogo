package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return the natural log of the input parameter
 * @author Brian
 *
 */
public class NaturalLog extends MathBoolCommand{

    public NaturalLog (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.log(this.getParams()[0]);
    }

}
