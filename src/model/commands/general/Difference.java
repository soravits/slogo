package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to return the first input number minus the sum of the next x inputs
 * @author Brian
 *
 */
public class Difference extends MathBoolCommand{

    public Difference (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        double x = this.getParams()[0];
        x *= 2;
        for (double i : this.getParams()){
            x -= i;
        }
        return x;
    }
}
