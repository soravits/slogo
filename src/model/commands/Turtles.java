package model.commands;

import model.Model;
import model.abstractcommands.TurtleCommand;

public class Turtles extends TurtleCommand{

    public Turtles (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return getModel().getNumberOfTurtles();
    }

}
