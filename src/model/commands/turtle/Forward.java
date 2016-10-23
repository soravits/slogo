package model.commands.turtle;

import model.Model;
import model.TurtleState;
import model.commands.Command;

public class Forward extends Command{

    Forward (double[] params, Model model) {
        super(params, model);
    }

    @Override
    public double execute (double[] parameters, Model slogoModel) {
        TurtleState turtle = slogoModel.getTurtle();
        double moveX = Math.sin(Math.toRadians(turtle.getTurtleAngle()))*parameters[0];
        double moveY = Math.cos(Math.toRadians(turtle.getTurtleAngle()))*parameters[1];
        turtle.addTurtleX(moveX);
        turtle.addTurtleY(moveY);
        return parameters[0];
    }

}
