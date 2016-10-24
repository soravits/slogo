package model.commands.bool;

import model.Model;
import model.commands.TwoInputCommand;

public class LessThan extends TwoInputCommand{

    public LessThan (double[] parameters, Model model) {
        super(parameters, model);        
    }

    @Override
    public double execute () {
        return (getParam1() < getParam2()) ? 1 : 0;
    }

}
