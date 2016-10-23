package model.commands.math;

import model.Model;
import model.commands.TwoInputCommand;

public class Sum extends TwoInputCommand{
        
    public Sum (double parameter1, double parameter2, Model model) {
        super(parameter1, parameter2, model);
    }

    @Override
    public double execute () {
        return getParam1() + getParam2();
    }
}
