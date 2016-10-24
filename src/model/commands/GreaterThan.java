package model.commands;

import model.Model;
import model.commandabstract.TwoInputCommand;

public class GreaterThan extends TwoInputCommand{

    public GreaterThan (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return (getParam1() > getParam2()) ? 1 : 0;
    }

}
