package model.commands;

import model.Model;

public abstract class TwoInputCommand extends OneInputCommand {

    private double param2;
    
    public TwoInputCommand (double parameter1, double parameter2, Model model) {
        super(parameter1, model);
        param2 = parameter2;
    }

    @Override
    public abstract double execute ();
    
    public double getParam2(){
        return param2;
    }

}
