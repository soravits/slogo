package model.commands;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class ArcTangent extends MathBoolCommand{

    public ArcTangent (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return Math.toDegrees(Math.atan(this.getParams()[0]));
    }

}
