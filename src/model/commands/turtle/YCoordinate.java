package model.commands.turtle;

import model.Model;
import model.abstractcommands.TurtleCommand;

public class YCoordinate extends TurtleCommand {

    public YCoordinate (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return getModel().getTurtle().getTurtleY();
    }

}
