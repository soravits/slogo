package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return the Tangent of the input argument (in degrees)
 * @author Brian
 *
 */
public class Tangent extends MathBoolCommand{

    public Tangent (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.tan(Math.toRadians(normalizeAngle(this.getParams()[0])));
    }

}
