package model.commands;

import model.Model;
import model.abstractcommands.OneInputCommand;

public class Cosine extends OneInputCommand{

    public Cosine (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.cos(Math.toRadians(getParam1()));
    }

}
