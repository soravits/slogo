package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class GreaterThan extends MathBoolCommand{

    public GreaterThan (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        double first = this.getParams()[0];
        for (double y : this.getParams()){
            if (first <= y){
                return 0;
            }
            first = y;
        }
        return 1;
    }

}
