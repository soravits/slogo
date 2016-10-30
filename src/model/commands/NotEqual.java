package model.commands;

import model.Model;
import model.abstractcommands.TwoInputCommand;

public class NotEqual extends TwoInputCommand {

    public NotEqual (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return (getParam1() != getParam2()) ? 1 : 0;
    }

}
