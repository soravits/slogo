package model.commands;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class NaturalLog extends MathBoolCommand{

    public NaturalLog (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.log(this.getParams()[0]);
    }

}
