package model.commands;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class IsShowing extends TurtleCommand {

    public IsShowing (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return (getModel().getTurtle().getShowTurtle()) ? 1 : 0;
    }

}
