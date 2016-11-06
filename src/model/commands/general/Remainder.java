package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return the remainder when dividing input 1 by input 2
 * @author Brian
 *
 */
public class Remainder extends MathBoolCommand {

    public Remainder (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return (this.getParams()[0] % this.getParams()[1]);
    }

}
