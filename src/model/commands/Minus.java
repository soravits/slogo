package model.commands;

import model.Model;
import model.abstractcommands.OneInputCommand;

public class Minus extends OneInputCommand {

    public Minus (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return -getParam1();
    }

}
