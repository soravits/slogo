package model.commands;

import model.Model;
import model.commandabstract.Command;

public class PenUp extends Command {

    PenUp (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () {
        this.getModel().getLineState().setPenDown(false);
        return 0;
    }

   
}
