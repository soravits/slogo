package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class XCoordinate extends TurtleCommand {

    public XCoordinate (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return getModel().getTurtle().getTurtleX();
    }

}
