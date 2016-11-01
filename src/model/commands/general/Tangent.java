package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Tangent extends MathBoolCommand{

    public Tangent (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.tan(Math.toRadians(this.getParams()[0]));
    }

}
