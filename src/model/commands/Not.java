package model.commands;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Not extends MathBoolCommand {

    public Not (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return (this.getParams()[0] == 0) ? 1 : 0;
    }

}
