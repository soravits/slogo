package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;


public class Left extends TurtleCommand{

    public Left (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        getModel().getTurtle().addTurtleAngle(-normalizeAngle(this.getParams()[0]));
        return this.getParams()[0];
    }    

}
