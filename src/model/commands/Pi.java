package model.commands;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Pi extends MathBoolCommand{

    public Pi (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return Math.PI;
    }

}
