package model.abstractcommands;

import model.interfaces.TurtleCommandInterface;

/**
 * A superclass which specifies that all Turtle Commands should have access to only the TurtleStates
 * and LineStates of the model. All Turtle commands work on exclusively the current Turtle as specified
 * by the TurtleMap inside of the model
 * @author Brian
 *
 */
public abstract class TurtleCommand extends GeneralCommand implements CommandInterface {

    private TurtleCommandInterface turtleModel;
    
    public TurtleCommand(double[] parameters, TurtleCommandInterface model){
        super(parameters);
        turtleModel = model;
    }
    
    /**
     * @return an interface that limits turtle commands to access to only LineStates and TurtleStates
     */
    public TurtleCommandInterface getModel(){
        return turtleModel;
    }
    
    public abstract double execute () throws Exception;
}
