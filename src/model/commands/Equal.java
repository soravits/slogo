package model.commands;

import model.Model;
import model.abstractcommands.TwoInputCommand;

public class Equal extends TwoInputCommand {

    public Equal (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return (getParam1() == getParam2()) ? 1 : 0;
    }
}
