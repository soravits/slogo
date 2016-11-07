// This entire file is part of my masterpiece
// Brian Keohane

/*
 * This is the concrete implementation of the Command Interface that was first executed back in the CommandController.
 * Note that it extends TurtleCommand, meaning that it only has access to the TurtleState and LineState of
 * the model. Also, it only has access to the *current* TurtleState and *current* LineState; nothing related
 * to implementing multiple turtles had to change any of the low-level commands. Forward simply moves one
 * turtle forward by the distance specified by the sum of the parameters. A mini strategy pattern is
 * also implemented by using the calculateCoordinates method. By simply changing the sign of the sum of the 
 * input parameters from positive to negative, the Backward command is implemented by extending Forward and
 * overwriting just the calculateCoordinates command. This helps greatly reduce the repeated code.
 * 
 * Another cool feature of this class is that it makes use of the clone() method created for the Position
 * class. Since variables in java are simply references, I needed a way to copy the values of the current
 * location in order to create the line from the current Position to the next Position. This method would
 * also prove useful in the event of the implementation of an undo() command. With short and well-named methods
 * and instance variables, this class is well-designed.
 */
package model.commands.turtle;

import model.Position;
import model.TurtleState;
import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to move the current turtle forward by d at its current heading, returns d
 * @author Brian
 *
 */
public class Forward extends TurtleCommand{

    public Forward (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        TurtleState turtle = this.getModel().getTurtle();
        Position prevPosition = turtle.getPosition().clone();
        double[] coords = calculateCoordinates(turtle);
        turtle.updateTurtlePosition(coords[0], coords[1]);
        this.getModel().getLineState().createLine(prevPosition, turtle.getPosition().clone());
        return sumParams();
    }
    
    /**
     * Calculate the new coordinates of the turtle after moving forward by d at its current heading
     * @param turtle : current active Turtle in the model's TurtleMap
     * @return the new coordinates for the Turtle
     */
    public double[] calculateCoordinates(TurtleState turtle){
        double[] coords = new double[2];
        double sumFD = sumParams();
        coords[0] = Math.sin(Math.toRadians(turtle.getTurtleAngle()))*sumFD;
        coords[1] = Math.cos(Math.toRadians(turtle.getTurtleAngle()))*sumFD;
        return coords;
    }
    

}
