package model.commands;

import model.Model;
import model.abstractcommands.OneInputCommand;

public class ArcTangent extends OneInputCommand{

    public ArcTangent (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.toDegrees(Math.atan(getParam1()));
    }

}
