package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to return 1 if any of the input arguments are nonzero; 0 otherwise
 * @author Brian
 *
 */
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
