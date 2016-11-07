package model.commands.general;

import model.interfaces.EmptyInterface;

/**
 * Command to Return 1 if the first input is less than the second input; 0 otherwise
 * @author Brian
 *
 */
public class LessThan extends Equal{

    public LessThan (double[] parameters, EmptyInterface model) {
        super(parameters, model);        
    }

    @Override
    public double execute () {
        return loopAll();
    }
    
    @Override
    protected boolean compareArgs(double x, double y){
        return x >= y;
    }

}
