package model.commands.math;

import model.Model;
import model.commands.Command;

public class Sum extends Command{
    
    public Sum(double[] parameters, Model model){
        super(parameters, model);
    }
    
    public double execute(double[] parameters, Model slogoModel){
        return parameters[0] + parameters[1];
    }
}
