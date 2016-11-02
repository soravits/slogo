package model.abstractcommands;

import model.interfaces.TurtleCommandInterface;

public abstract class TurtleCommand extends GeneralCommand implements CommandInterface {

    private TurtleCommandInterface turtleModel;
    
    public TurtleCommand(double[] parameters, TurtleCommandInterface model){
        super(parameters);
        turtleModel = model;
    }
    
    public TurtleCommandInterface getModel(){
        return turtleModel;
    }
    
    public abstract double execute () throws Exception;
}
