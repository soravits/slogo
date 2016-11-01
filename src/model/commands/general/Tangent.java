package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Tangent extends MathBoolCommand{

    public Tangent (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.tan(Math.toRadians(this.getParams()[0]));
    }

}
