package model.commands;

import model.Model;
import model.commandabstract.OneInputCommand;

public class Left extends OneInputCommand{

    public Left (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        getModel().getTurtle().addTurtleAngle(-normalizeAngle(getParam1()));
        return getParam1();
    }    

}
