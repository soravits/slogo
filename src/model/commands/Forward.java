package model.commands;

import model.LineState;
import model.Model;
import model.Position;
import model.TurtleState;
import model.commandabstract.OneInputCommand;

public class Forward extends OneInputCommand{

    public Forward (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        TurtleState turtle = this.getModel().getTurtle();
        Position prevPosition = turtle.getPosition().clone();
        LineState lines = this.getModel().getLineState();
        double[] coords = calculateCoordinates(turtle);
        turtle.updateTurtlePosition(coords[0], coords[1]);
        lines.createLine(prevPosition, turtle.getPosition());
        return this.getParam1();
    }
    
    public double[] calculateCoordinates(TurtleState turtle){
        double[] coords = new double[2];
        coords[0] = Math.sin(Math.toRadians(turtle.getTurtleAngle()))*this.getParam1();
        coords[1] = Math.cos(Math.toRadians(turtle.getTurtleAngle()))*this.getParam1();
        return coords;
    }
    

}
