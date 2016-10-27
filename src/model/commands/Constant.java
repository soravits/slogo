package model.commands;

import model.Model;
import model.abstractcommands.OneInputCommand;

public class Constant extends OneInputCommand {

    public Constant (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return getParam1();
    }

}
