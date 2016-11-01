package model.commands;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class And extends MathBoolCommand{

    public And (double[] parameters, EmptyInterface model) {
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
