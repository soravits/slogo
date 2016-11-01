package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class GreaterThan extends MathBoolCommand{

    public GreaterThan (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
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
