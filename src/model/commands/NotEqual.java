package model.commands;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class NotEqual extends MathBoolCommand {

    public NotEqual (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        double first = this.getParams()[0];
        for (double y : this.getParams()){
            if (y == first){
                return 0;
            }
        }
        return 1;
    }

}
