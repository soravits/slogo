package model.commands.turtle;

import model.Model;
import model.abstractcommands.TurtleCommand;

public class Right extends TurtleCommand{

    public Right (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        getModel().getTurtle().addTurtleAngle(normalizeAngle(this.getParams()[0]));
        return this.getParams()[0];
    }
    
}
