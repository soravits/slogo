package model.commands.bool;

import model.Model;
import model.commands.TwoInputCommand;

public class LessThan extends TwoInputCommand{

    public LessThan (double param1, double param2, Model model) {
        super(param1, param2, model);        
    }

    @Override
    public double execute () {
        return (getParam1() < getParam2()) ? 1 : 0;
    }

}
