package model.commands.turtle;

import model.TurtleState;
import model.interfaces.TurtleCommandInterface;

/**
 * Move the current Turtle backwards by dist, return the distance moved by the Turtle
 * @author Brian
 *
 */
public class Backward extends Forward {

    public Backward (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }
    
    /**
     * Return the new coordinates of the turtle after moving backwards
     */
    @Override
    public double[] calculateCoordinates(TurtleState turtle){
        double[] coords = new double[2];
        double sumD = sumParams();
        coords[0] = -Math.sin(Math.toRadians(turtle.getTurtleAngle()))*sumD;
        coords[1] = -Math.cos(Math.toRadians(turtle.getTurtleAngle()))*sumD;
        return coords;
    }

}
