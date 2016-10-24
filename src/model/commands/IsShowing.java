package model.commands;

import model.Model;
import model.commandabstract.Command;

public class IsShowing extends Command {

    public IsShowing (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () throws Exception {
        return (getModel().getTurtle().getShowTurtle()) ? 1 : 0;
    }

}
