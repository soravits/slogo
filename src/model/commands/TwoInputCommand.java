package model.commands;

import model.Model;

public abstract class TwoInputCommand extends OneInputCommand {

    private double param2;
    
    public TwoInputCommand (double[] parameters, Model model) {
        super(parameters, model);
        param2 = parameters[1];
    }

    public double getParam2(){
        return param2;
    }

}
