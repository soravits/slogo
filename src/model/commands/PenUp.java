package model.commands;

import model.Model;
import model.abstractcommands.TurtleCommand;

public class PenUp extends TurtleCommand{

    public PenUp (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        this.getModel().getLineState().setPenDown(false);
        return 0;
    }

   
}
