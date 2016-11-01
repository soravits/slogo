package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Minus extends MathBoolCommand {

    public Minus (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return -this.getParams()[0];
    }

}
