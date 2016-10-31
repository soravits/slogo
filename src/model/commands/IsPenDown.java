package model.commands;

import model.Model;
import model.abstractcommands.Command;
import model.abstractcommands.TurtleCommand;

public class IsPenDown extends TurtleCommand{

    public IsPenDown (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return (getModel().getLineState().isPenDown()) ? 1 : 0;
    }

}
