package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Not extends MathBoolCommand {

    public Not (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return (this.getParams()[0] == 0) ? 1 : 0;
    }

}
