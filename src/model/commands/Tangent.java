package model.commands;

import model.Model;
import model.commandabstract.OneInputCommand;

public class Tangent extends OneInputCommand{

    public Tangent (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.tan(Math.toRadians(getParam1()));
    }

}
