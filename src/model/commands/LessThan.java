package model.commands;

import model.Model;
import model.abstractcommands.TwoInputCommand;

public class LessThan extends TwoInputCommand{

    public LessThan (double[] parameters, Model model) {
        super(parameters, model);        
    }

    @Override
    public double execute () {
        return (getParam1() < getParam2()) ? 1 : 0;
    }

}
