package model.commands;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class IsPenDown extends TurtleCommand{

    public IsPenDown (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return (getModel().getLineState().isPenDown()) ? 1 : 0;
    }

}
