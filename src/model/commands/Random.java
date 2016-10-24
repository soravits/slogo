package model.commands;

import model.Model;
import model.commandabstract.OneInputCommand;

public class Random extends OneInputCommand{

    public Random (double[] parameter, Model model) {
        super(parameter, model);
    }

    @Override
    public double execute () throws Exception {
        return  Math.random() * getParam1();
    }

}
