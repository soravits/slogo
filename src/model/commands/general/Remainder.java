package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Remainder extends MathBoolCommand {

    public Remainder (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return (this.getParams()[0] % this.getParams()[1]);
    }

}
