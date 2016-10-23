package model.commands;

import model.Model;

public abstract class Command {
    
    private Model slogoModel;
    
    public Command(Model model){
        slogoModel = model;
    }

    public abstract double execute ();
    
    public Model getModel(){
        return slogoModel;
    } 
    
    // NEED TO MOVE THIS SOMEWHERE BETTER!!!!
    public double normalizeAngle(double angle){
        double normalizedAngle = angle % 360;
        if (normalizedAngle < 0){
            normalizedAngle += 360;
        }
        return normalizedAngle;
    }
}
