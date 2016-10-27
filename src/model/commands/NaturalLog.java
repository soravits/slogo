package model.commands;

import model.Model;
import model.abstractcommands.OneInputCommand;

public class NaturalLog extends OneInputCommand{

    public NaturalLog (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.log(getParam1());
    }

}
