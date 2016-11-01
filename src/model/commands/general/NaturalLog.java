package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class NaturalLog extends MathBoolCommand{

    public NaturalLog (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.log(this.getParams()[0]);
    }

}
