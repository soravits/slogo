package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Minus extends MathBoolCommand {

    public Minus (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return -this.getParams()[0];
    }

}
