package model.commands;

import model.Model;
import model.commandabstract.Command;

public class ShowTurtle extends Command{

    public ShowTurtle (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () throws Exception {
        getModel().getTurtle().setShowTurtle(true);
        return 1;
    }
    
}
