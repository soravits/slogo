package model.commands;

import model.Model;
import model.abstractcommands.Command;

public class XCoordinate extends Command {

    public XCoordinate (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () {
        return getModel().getTurtle().getTurtleX();
    }

}
