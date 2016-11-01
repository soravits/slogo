package model.commands;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Or extends MathBoolCommand{

    public Or (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        for (double y : this.getParams()){
            if (y != 0){
                return 1;
            }
        }
        return 0;
    }

}
