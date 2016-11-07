package model.abstractcommands;

import model.interfaces.EmptyInterface;

/**
 * A superclass which specifies that all math/boolean Commands should have no access to the inner workings
 * of the model
 * @author Brian
 *
 */
public abstract class MathBoolCommand extends GeneralCommand implements CommandInterface {

    private EmptyInterface emptyModel;

    public MathBoolCommand(double[] parameters, EmptyInterface model){
        super(parameters);
        emptyModel = model;
    }
    
    /**
     * @return an empty interface to be ignored by each of the math/boolean commands
     */
    protected EmptyInterface getModel(){
        return emptyModel;
    }
    

    @Override
    public abstract double execute () throws Exception;

}
