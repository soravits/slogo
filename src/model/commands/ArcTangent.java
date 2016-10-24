package model.commands;

import model.Model;
import model.commandabstract.OneInputCommand;

public class ArcTangent extends OneInputCommand{

    public ArcTangent (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return Math.toDegrees(Math.atan(getParam1()));
    }

}
