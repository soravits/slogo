package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class ArcTangent extends MathBoolCommand{

    public ArcTangent (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return Math.toDegrees(Math.atan(this.getParams()[0]));
    }

}
