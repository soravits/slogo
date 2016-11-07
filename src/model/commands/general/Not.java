package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return 1 if the input is 0; otherwise returns 0
 * @author Brian
 *
 */
public class Not extends MathBoolCommand {

    public Not (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return (this.getParams()[0] == 0) ? 1 : 0;
    }

}
