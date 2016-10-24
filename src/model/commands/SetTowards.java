package model.commands;

import model.Model;
import model.commandabstract.TwoInputCommand;

public class SetTowards extends TwoInputCommand{

    public SetTowards (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        double xDiff = this.getParam1() - this.getModel().getTurtle().getTurtleX();
        double yDiff = this.getParam2() - this.getModel().getTurtle().getTurtleY();
        double angle = normalizeAngle(Math.toDegrees(Math.acos(yDiff/Math.sqrt((xDiff*xDiff + yDiff*yDiff)))));
        if (xDiff < 0 & yDiff <= 0){
            angle = 360 - angle;
        }
        else if (xDiff < 0 & yDiff > 0){
            angle = 360 - angle;
        }
        double currentAngle = this.getModel().getTurtle().getTurtleAngle();
        System.out.println(currentAngle);
        System.out.println(angle);
        this.getModel().getTurtle().setTurtleAngle(angle);
        return Math.abs(angle - currentAngle);      
    }
}
