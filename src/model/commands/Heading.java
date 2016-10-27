package model.commands;

import model.Model;
import model.abstractcommands.Command;

public class Heading extends Command{

    public Heading (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () throws Exception {
        return getModel().getTurtle().getTurtleAngle();
    }

}
