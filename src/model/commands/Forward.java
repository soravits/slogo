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
        double moveX = Math.sin(Math.toRadians(turtle.getTurtleAngle()))*this.getParam1();
        double moveY = Math.cos(Math.toRadians(turtle.getTurtleAngle()))*this.getParam1();
        turtle.updateTurtlePosition(moveX, moveY);
        lines.createLine(prevPosition, turtle.getPosition());
        return this.getParam1();
    }

}
