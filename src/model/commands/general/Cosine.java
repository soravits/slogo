package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return the cosine of an angle (in degrees)
 * @author Brian
 *
 */
public class Cosine extends MathBoolCommand{

    public Cosine (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.cos(Math.toRadians(normalizeAngle(this.getParams()[0])));
    }

}
