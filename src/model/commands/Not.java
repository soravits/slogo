package model.commands;

import model.Model;
import model.commandabstract.OneInputCommand;

public class Not extends OneInputCommand {

    public Not (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return (getParam1() == 0) ? 1 : 0;
    }

}
