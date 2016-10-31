package model.commands;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class And extends MathBoolCommand{

    public And (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        for (double x : this.getParams()){
            if (x == 0.0){
                return 0;
            }
        }
        return 1;
    }

}
