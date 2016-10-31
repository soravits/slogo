package model.commands;

import model.LineState;
import model.Model;
import model.Position;
import model.TurtleState;
import model.abstractcommands.OneInputCommand;
import model.abstractcommands.TurtleCommand;

public class Forward extends TurtleCommand{

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
        lines.createLine(prevPosition, turtle.getPosition().clone());
        return this.getParams()[0];
    }
    
    public double[] calculateCoordinates(TurtleState turtle){
        double[] coords = new double[2];
        double sumFD = 0;
        for (double x : this.getParams()){
            sumFD += x;
        }
        coords[0] = Math.sin(Math.toRadians(turtle.getTurtleAngle()))*sumFD;
        coords[1] = Math.cos(Math.toRadians(turtle.getTurtleAngle()))*sumFD;
        return coords;
    }
    

}
