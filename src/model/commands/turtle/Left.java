package model.commands.turtle;

import model.Model;
import model.abstractcommands.OneInputCommand;
import model.abstractcommands.TurtleCommand;

public class Left extends TurtleCommand{

    public Left (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        getModel().getTurtle().addTurtleAngle(-normalizeAngle(this.getParams()[0]));
        return this.getParams()[0];
    }    

}
