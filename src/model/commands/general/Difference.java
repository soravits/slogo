package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Difference extends MathBoolCommand{

    public Difference (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        double x = this.getParams()[0];
        for (double i : this.getParams()){
            x -= i;
        }
        return x;
    }
}
