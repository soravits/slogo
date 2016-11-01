package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Sum extends MathBoolCommand{
        
    public Sum (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        double sum = 0;
        for (double x : this.getParams()){
            sum += x;
        }
        return sum;
    }
}
