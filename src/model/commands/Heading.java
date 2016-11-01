package model.commands;

import model.Model;
import model.abstractcommands.TurtleCommand;

public class Heading extends TurtleCommand{

    public Heading (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return getModel().getTurtle().getTurtleAngle();
    }

}
