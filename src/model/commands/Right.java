package model.commands;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class Right extends TurtleCommand{

    public Right (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        getModel().getTurtle().addTurtleAngle(normalizeAngle(this.getParams()[0]));
        return this.getParams()[0];
    }
    
}
