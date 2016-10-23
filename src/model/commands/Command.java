package model.commands;

import model.Model;

public abstract class Command implements CommandInterface{
    
    private double[] parameters;
    private Model slogoModel;
    
    public Command(double[] params, Model model){
        parameters = params;
        slogoModel = model;
    }

    @Override
    public double execute (){
        return execute(parameters, slogoModel);
    };

    @Override
    public abstract double execute (double[] params, Model model);
    
    

}
