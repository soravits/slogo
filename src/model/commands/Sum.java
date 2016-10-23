package model.commands;

import model.Model;

public class Sum extends Command{
    
    public Sum(double[] parameters, Model model){
        super(parameters, model);
    }
    
    public double execute(){
        return parameters[0] + parameters[1];
    }
}
