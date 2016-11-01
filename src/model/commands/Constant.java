package model.commands;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Constant extends MathBoolCommand {

    public Constant (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return this.getParams()[0];
    }

}
