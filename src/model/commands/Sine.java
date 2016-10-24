package model.commands;

import model.Model;
import model.commandabstract.OneInputCommand;

public class Sine extends OneInputCommand{

    public Sine (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.sin(Math.toRadians(getParam1()));
    }

}
