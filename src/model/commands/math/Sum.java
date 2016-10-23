package model.commands.math;

import model.Model;
import model.commands.TwoInputCommand;

public class Sum extends TwoInputCommand{
        
    public Sum (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return getParam1() + getParam2();
    }
}
