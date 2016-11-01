package model.commands;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Cosine extends MathBoolCommand{

    public Cosine (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.cos(Math.toRadians(this.getParams()[0]));
    }

}
