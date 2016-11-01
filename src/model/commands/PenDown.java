package model.commands;

import model.Model;
import model.abstractcommands.TurtleCommand;

public class PenDown extends TurtleCommand{

    public PenDown (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        getModel().getLineState().setPenDown(true);
        return 1;
    }
    
    

}
