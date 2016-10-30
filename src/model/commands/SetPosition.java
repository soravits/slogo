package model.commands;

import model.Model;
import model.TurtleState;
import model.abstractcommands.TwoInputCommand;

public class SetPosition extends TwoInputCommand{

    public SetPosition (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        TurtleState turtle = getModel().getTurtle();
        double dist = turtle.getPosition().clone().distance(getParam1(), getParam2());
        turtle.setTurtlePosition(getParam1(), getParam2());
        return dist;
    }

}
