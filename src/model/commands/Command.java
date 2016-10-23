package model.commands;

import model.Model;
import model.Position;

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
    
    public void drawLines(Position pos1, Position pos2){
        if (slogoModel.getLineState().isPenDown()){
            slogoModel.getLineState().createLine(pos1, pos2);
        }   
    }

}
