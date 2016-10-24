package model.commands;

import model.Model;
import model.commandabstract.OneInputCommand;

public class Minus extends OneInputCommand {

    public Minus (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return -getParam1();
    }

}
