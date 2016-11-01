package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class IsPenDown extends TurtleCommand{

    public IsPenDown (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        System.out.println(getModel().getLineState().isPenDown());
        return (getModel().getLineState().isPenDown()) ? 1 : 0;
    }

}
