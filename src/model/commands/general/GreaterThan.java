package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class GreaterThan extends MathBoolCommand{

    public GreaterThan (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return (this.getParams()[0] > this.getParams()[1]) ? 1 : 0;
    }

}
