package model.commands;

import model.Model;

public abstract class OneInputCommand extends Command{
    
    private double param1;

    public OneInputCommand (double parameter, Model model) {
        super(model);
        param1 = parameter;
    }

    public double getParam1(){
        return param1;
    }
}
