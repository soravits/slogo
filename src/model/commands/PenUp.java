package model.commands;

import model.Model;
import model.abstractcommands.Command;

public class PenUp extends Command {

    public PenUp (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () {
        this.getModel().getLineState().setPenDown(false);
        return 0;
    }

   
}
