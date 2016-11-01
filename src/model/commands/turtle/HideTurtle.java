package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class HideTurtle extends TurtleCommand{

    public HideTurtle (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        getModel().getTurtle().setShowTurtle(false);
        return 1;
    }
    
}
