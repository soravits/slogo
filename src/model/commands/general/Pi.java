package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Pi extends MathBoolCommand{

    public Pi (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return Math.PI;
    }

}
