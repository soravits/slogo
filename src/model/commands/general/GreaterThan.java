package model.commands.general;

import model.interfaces.EmptyInterface;

/**
 * Command to Return 1 if the first input is greater than the second input; 0 otherwise
 * @author Brian
 *
 */
public class GreaterThan extends Equal{

    public GreaterThan (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return loopAll();
    }
    
    @Override
    protected boolean compareArgs(double x, double y){
        return x <= y;
    }

}
