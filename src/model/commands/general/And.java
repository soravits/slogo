package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return 1 if no parameters are 0; 0 otherwise
 * @author Brian
 *
 */
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
