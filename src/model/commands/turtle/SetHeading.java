package model.commands.turtle;

import model.Model;

public class SetHeading extends CommandTurtle{

    SetHeading (double[] params, Model model) {
        super(params, model);
    }

    @Override
    public double execute (double[] parameters, Model slogoModel) {
        double currentAngle = slogoModel.getTurtle().getTurtleAngle();
        slogoModel.getTurtle().setTurtleAngle(normalizeAngle(parameters[0]));
        return parameters[0] - currentAngle;
    }

    
}
