package model.commands;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class YCoordinate extends TurtleCommand {

    public YCoordinate (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return getModel().getTurtle().getTurtleY();
    }

}
