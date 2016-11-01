package model.commands;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class LessThan extends MathBoolCommand{

    public LessThan (double[] parameters, Model model) {
        super(parameters, model);        
    }

    @Override
    public double execute () {
        double first = this.getParams()[0];
        for (double y : this.getParams()){
            if (first >= y){
                return 0;
            }
            first = y;
        }
        return 1;
    }

}
