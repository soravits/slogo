package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Sine extends MathBoolCommand{

    public Sine (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return Math.sin(Math.toRadians(this.getParams()[0]));
    }

}
