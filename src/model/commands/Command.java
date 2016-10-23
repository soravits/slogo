package model.commands;

import model.Model;

public abstract class Command implements CommandInterface{
    
    protected double[] parameters;
    protected Model slogoModel;
    
    Command(double[] params, Model model){
        parameters = params;
        slogoModel = model;
    }
    
    public double normalizeAngle(double angle){
        double normalizedAngle = angle % 360;
        if (normalizedAngle < 0){
            normalizedAngle += 360;
        }
        return normalizedAngle;
    }

    @Override
    public abstract double execute ();
    
    

}
