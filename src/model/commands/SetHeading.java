package model.commands;

import model.Model;

public class SetHeading extends Command{

    SetHeading (double[] params, Model model) {
        super(params, model);
    }

    @Override
    public double execute () {
        double currentAngle = slogoModel.getTurtle().getTurtleAngle();
        slogoModel.getTurtle().setTurtleAngle(normalizeAngle(parameters[0]));
        return parameters[0] - currentAngle;
    }

    
}
