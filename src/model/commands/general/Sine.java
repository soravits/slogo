package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return the sine value of the argument (in degrees)
 * @author Brian
 *
 */
public class Sine extends MathBoolCommand{

    public Sine (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return Math.sin(Math.toRadians(normalizeAngle(this.getParams()[0])));
    }

}
