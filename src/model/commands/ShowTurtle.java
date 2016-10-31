package model.commands;

import model.Model;
import model.abstractcommands.TurtleCommand;

public class ShowTurtle extends TurtleCommand{

    public ShowTurtle (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        getModel().getTurtle().setShowTurtle(true);
        return 1;
    }
    
}
