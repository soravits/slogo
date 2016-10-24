package model.commands;

import model.Model;
import model.commandabstract.Command;

public class YCoordinate extends Command {

    public YCoordinate (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () {
        return getModel().getTurtle().getTurtleY();
    }

}
