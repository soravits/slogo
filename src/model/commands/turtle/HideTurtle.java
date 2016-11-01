package model.commands.turtle;

import model.Model;
import model.abstractcommands.TurtleCommand;

public class HideTurtle extends TurtleCommand{

    public HideTurtle (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        getModel().getTurtle().setShowTurtle(false);
        return 1;
    }
    
}
