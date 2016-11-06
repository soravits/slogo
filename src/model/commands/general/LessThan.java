package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return 1 if the first input is less than the second input; 0 otherwise
 * @author Brian
 *
 */
public class LessThan extends MathBoolCommand{

    public LessThan (double[] parameters, EmptyInterface model) {
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
