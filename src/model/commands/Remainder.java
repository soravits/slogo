package model.commands;

import model.Model;
import model.commandabstract.TwoInputCommand;

public class Remainder extends TwoInputCommand {

    public Remainder (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return getParam1() % getParam2();
    }

}
