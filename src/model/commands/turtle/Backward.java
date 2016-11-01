package model.commands.turtle;

import model.TurtleState;
<<<<<<< HEAD:src/model/commands/Backward.java
import model.interfaces.TurtleCommandInterface;
=======
import model.commands.turtle.Forward;
>>>>>>> master:src/model/commands/turtle/Backward.java

public class Backward extends Forward {

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
