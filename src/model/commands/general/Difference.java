package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Difference extends MathBoolCommand{

    public Difference (double[] parameters, EmptyInterface model) {
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
