package model.commands;

import model.Model;
import model.abstractcommands.Command;

public class PenDown extends Command{

    public PenDown (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () throws Exception {
        getModel().getLineState().setPenDown(true);
        return 1;
    }
    
    

}
