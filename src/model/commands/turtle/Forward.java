package model.commands.turtle;

import model.LineState;
import model.Model;
import model.TurtleState;
import model.commands.OneInputCommand;

public class Forward extends OneInputCommand{

    Forward (double param1, Model model) {
        super(param1, model);
    }

    @Override
    public double execute () {
        TurtleState turtle = this.getModel().getTurtle();
        LineState lines = this.getModel().getLineState();
        double moveX = Math.sin(Math.toRadians(turtle.getTurtleAngle()))*this.getParam1();
        double moveY = Math.cos(Math.toRadians(turtle.getTurtleAngle()))*this.getParam1();
        turtle.addTurtleX(moveX);
        turtle.addTurtleY(moveY);
        return this.getParam1();
    }

}
