package model.commands;

import model.Model;
import model.commandabstract.Command;

public class HideTurtle extends Command{

    public HideTurtle (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () throws Exception {
        getModel().getTurtle().setShowTurtle(false);
        return 1;
    }
    
}
