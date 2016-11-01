package model.commands.general;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class Heading extends TurtleCommand{

    public Heading (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return getModel().getTurtle().getTurtleAngle();
    }

}
