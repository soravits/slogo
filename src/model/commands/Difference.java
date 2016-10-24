package model.commands;

import model.Model;
import model.commandabstract.TwoInputCommand;

public class Difference extends TwoInputCommand{

    public Difference (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return getParam1() - getParam2();
    }
}
