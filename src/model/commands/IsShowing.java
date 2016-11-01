package model.commands;

import model.Model;
import model.abstractcommands.Command;
import model.abstractcommands.TurtleCommand;

public class IsShowing extends TurtleCommand {

    public IsShowing (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return (getModel().getTurtle().getShowTurtle()) ? 1 : 0;
    }

}
