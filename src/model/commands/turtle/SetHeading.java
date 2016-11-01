package model.commands.turtle;

import model.Model;
import model.abstractcommands.TurtleCommand;

public class SetHeading extends TurtleCommand{

    public SetHeading (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        double currentAngle = this.getModel().getTurtle().getTurtleAngle();
        this.getModel().getTurtle().setTurtleAngle(normalizeAngle(this.getParams()[0]));
        return this.getParams()[0] - currentAngle;
    }

    
}
