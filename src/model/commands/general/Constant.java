package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Constant extends MathBoolCommand {

    public Constant (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return this.getParams()[0];
    }

}
