package model.commands.turtle;

import model.LineState;
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
        LineState lines = this.getModel().getLineState();
        double[] coords = calculateCoordinates(turtle);
        turtle.updateTurtlePosition(coords[0], coords[1]);
        lines.createLine(prevPosition, turtle.getPosition().clone());
        return this.getParams()[0];
    }
    
    /**
     * Calculate the new coordinates of the turtle after moving forward by d at its current heading
     * @param turtle
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
