// This entire file is part of my masterpiece
// Brian Keohane

/*
 * This class is the abstract class that extends the GeneralCommand class. It does so by specifying that each
 * of its subclasses will receive the model as a TurtleCommandInterface, providing access only to the Turtles
 * and LineStates within the model. Each Turtle Command also implements the CommandInterface, which means
 * every subclass needs an execute() method that returns a double.
 * 
 * This class shows good design because it fits well within the hierarchy of Command structure for the program.
 * Receiving the model as a TurtleCommandInterface limits the amount of implementation of the model that is
 * exposed to the low-level commands. The class is also well-documented, methods and variables are well-named,
 * and there is no duplicated code.
 */

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
    protected TurtleCommandInterface getModel(){
        return turtleModel;
    }
    
    public abstract double execute () throws Exception;
}
