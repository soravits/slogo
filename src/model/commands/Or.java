package model.commands;

import model.Model;
import model.abstractcommands.TwoInputCommand;

public class Or extends TwoInputCommand{

    public Or (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return (getParam1() != 0 | getParam2() != 0) ? 1 : 0;
    }

}
