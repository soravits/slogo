package model.commands;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class PenDown extends TurtleCommand{

    public PenDown (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        getModel().getLineState().setPenDown(true);
        return 1;
    }
    
    

}
