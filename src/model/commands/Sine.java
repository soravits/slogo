package model.commands;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Sine extends MathBoolCommand{

    public Sine (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return Math.sin(Math.toRadians(this.getParams()[0]));
    }

}
