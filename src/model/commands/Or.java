package model.commands;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Or extends MathBoolCommand{

    public Or (double[] parameters, Model model) {
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
