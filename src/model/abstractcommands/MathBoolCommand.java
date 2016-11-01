package model.abstractcommands;

import model.interfaces.EmptyInterface;

public abstract class MathBoolCommand extends GeneralCommand implements CommandInterface {

    private EmptyInterface emptyModel;

    public MathBoolCommand(double[] parameters, EmptyInterface model){
        super(parameters);
        emptyModel = model;
    }
    
    public EmptyInterface getModel(){
        return emptyModel;
    }
    
    @Override
    public abstract double execute () throws Exception;

}
