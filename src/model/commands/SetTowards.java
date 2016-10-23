package model.commands;

import model.Model;

public class SetTowards extends Command{

    SetTowards (double[] params, Model model) {
        super(params, model);
    }

    @Override
    public double execute () {
        double xDiff = parameters[0] - slogoModel.getTurtle().getTurtleX();
        double yDiff = parameters[1] - slogoModel.getTurtle().getTurtleY();
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
        double currentAngle = slogoModel.getTurtle().getTurtleAngle();
        slogoModel.getTurtle().setTurtleAngle(angle);
        return Math.abs(angle - currentAngle);       
    }

    
}
