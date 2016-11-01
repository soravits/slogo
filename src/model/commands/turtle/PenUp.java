package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class PenUp extends TurtleCommand{

    public PenUp (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        this.getModel().getLineState().setPenDown(false);
        return 0;
    }

   
}
