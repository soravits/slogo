package model.commands.bool;

import model.Model;
import model.commands.TwoInputCommand;

public class And extends TwoInputCommand{

    public And (double param1, double param2, Model model) {
        super(param1, param2, model);
    }

    @Override
    public double execute () {
        return ((getParam1() != 0) & (getParam2() != 0)) ? 1 : 0;
    }

}
