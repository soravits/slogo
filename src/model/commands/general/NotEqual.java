package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return 1 if two arguments are not equal; 0 otherwise
 * @author Brian
 *
 */
public class NotEqual extends MathBoolCommand {

    public NotEqual (double[] parameters, EmptyInterface model) {
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
