package model.commands;

import model.Model;
import model.commandabstract.Command;

public class XCoordinate extends Command {

    public XCoordinate (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () {
        return getModel().getTurtle().getTurtleX();
    }

}