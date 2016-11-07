package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to Return whether or not two arguments are equal
 * @author Brian
 *
 */
public class Equal extends MathBoolCommand {

    public Equal (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return loopAll();
    }
    
    protected double loopAll(){
        double first = this.getParams()[0];
        for (int i = 1; i < this.getParams().length; i++){
            if (compareArgs(first, this.getParams()[i])){
                return 0;
            }
        }
        return 1;
    }
    
    protected boolean compareArgs (double x, double y){
        return x != y;
    }
}
