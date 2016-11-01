package model.commands;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Random extends MathBoolCommand{

    public Random (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return  Math.random() * this.getParams()[0];
    }

}
