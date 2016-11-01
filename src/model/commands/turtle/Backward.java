package model.commands.turtle;

import model.Model;
import model.TurtleState;
import model.commands.turtle.Forward;

public class Backward extends Forward {

    public Backward (double[] parameters, Model model) {
        super(parameters, model);
    }
    
    public double[] calculateCoordinates(TurtleState turtle){
        double[] coords = new double[2];
        coords[0] = -Math.sin(Math.toRadians(turtle.getTurtleAngle()))*this.getParams()[0];
        coords[1] = -Math.cos(Math.toRadians(turtle.getTurtleAngle()))*this.getParams()[0];
        return coords;
    }

}
