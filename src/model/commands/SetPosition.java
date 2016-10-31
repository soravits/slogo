package model.commands;

import model.Model;
import model.TurtleState;
import model.abstractcommands.TurtleCommand;

public class SetPosition extends TurtleCommand{

    public SetPosition (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        TurtleState turtle = getModel().getTurtle();
        double dist = turtle.getPosition().clone().distance(this.getParams()[0], this.getParams()[1]);
        turtle.setTurtlePosition(this.getParams()[0], this.getParams()[1]);
        return dist;
    }

}
