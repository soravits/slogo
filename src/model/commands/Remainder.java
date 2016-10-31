package model.commands;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Remainder extends MathBoolCommand {

    public Remainder (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return (this.getParams()[0] % this.getParams()[1]);
    }

}
