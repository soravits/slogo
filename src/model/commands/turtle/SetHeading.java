package model.commands.turtle;

import model.Model;
import model.commands.OneInputCommand;

public class SetHeading extends OneInputCommand{

    SetHeading (double param1, Model model) {
        super(param1, model);
    }

    @Override
    public double execute () {
        double currentAngle = this.getModel().getTurtle().getTurtleAngle();
        this.getModel().getTurtle().setTurtleAngle(normalizeAngle(this.getParam1()));
        return this.getParam1() - currentAngle;
    }

    
}
