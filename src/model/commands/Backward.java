package model.commands;

import model.TurtleState;
import model.interfaces.TurtleCommandInterface;

public class Backward extends Forward{

    public Backward (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }
    
    public double[] calculateCoordinates(TurtleState turtle){
        double[] coords = new double[2];
        double sumD = sumParams();
        coords[0] = -Math.sin(Math.toRadians(turtle.getTurtleAngle()))*sumD;
        coords[1] = -Math.cos(Math.toRadians(turtle.getTurtleAngle()))*sumD;
        return coords;
    }

}
