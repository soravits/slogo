package model.commands.bool;

import model.Model;
import model.commands.TwoInputCommand;

public class And extends TwoInputCommand{

    public And (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return ((getParam1() != 0) & (getParam2() != 0)) ? 1 : 0;
    }

}
