package model.commands.turtle;

import model.Model;
import model.commands.TwoInputCommand;

public class SetTowards extends TwoInputCommand{

    SetTowards (double param1, double param2, Model model) {
        super(param1, param2, model);
    }

    @Override
    public double execute () {
        double xDiff = this.getParam1() - this.getModel().getTurtle().getTurtleX();
        double yDiff = this.getParam2() - this.getModel().getTurtle().getTurtleY();
        double angle = normalizeAngle(Math.toDegrees(Math.acos(yDiff/(xDiff*xDiff + yDiff*yDiff))));
        if (xDiff > 0 & yDiff < 0){ // turtle is top-left to new point
            angle = 180 - angle;
        }
        else if (xDiff < 0 & yDiff < 0){
            angle += 180;
        }
        else if (xDiff < 0 & yDiff > 0){
            angle = 360 - angle;
        }
        double currentAngle = this.getModel().getTurtle().getTurtleAngle();
        this.getModel().getTurtle().setTurtleAngle(angle);
        return Math.abs(angle - currentAngle);      
    }
}
