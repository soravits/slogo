package model.commands;

import model.Model;
import model.TurtleState;

public class Backward extends Forward{

    public Backward (double[] parameters, Model model) {
        super(parameters, model);
    }
    
    public double[] calculateCoordinates(TurtleState turtle){
        double[] coords = new double[2];
        coords[0] = -Math.sin(Math.toRadians(turtle.getTurtleAngle()))*this.getParam1();
        coords[1] = -Math.cos(Math.toRadians(turtle.getTurtleAngle()))*this.getParam1();
        return coords;
    }

}
