package model.commands;

import model.Model;
import model.abstractcommands.TurtleCommand;

public class XCoordinate extends TurtleCommand {

    public XCoordinate (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return getModel().getTurtle().getTurtleX();
    }

}
