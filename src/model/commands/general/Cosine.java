package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Cosine extends MathBoolCommand{

    public Cosine (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.cos(Math.toRadians(this.getParams()[0]));
    }

}
