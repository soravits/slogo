package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class SetTowards extends TurtleCommand{

    public SetTowards (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        double xDiff = this.getParams()[0] - this.getModel().getTurtle().getTurtleX();
        double yDiff = this.getParams()[1] - this.getModel().getTurtle().getTurtleY();
        double angle = normalizeAngle(Math.toDegrees(Math.acos(yDiff/Math.sqrt((xDiff*xDiff + yDiff*yDiff)))));
        if (xDiff < 0 & yDiff <= 0){
            angle = 360 - angle;
        }
        else if (xDiff < 0 & yDiff > 0){
            angle = 360 - angle;
        }
        double currentAngle = this.getModel().getTurtle().getTurtleAngle();
        this.getModel().getTurtle().setTurtleAngle(angle);
        return Math.abs(angle - currentAngle);      
    }
}
