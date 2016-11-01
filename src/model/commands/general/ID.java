package model.commands.general;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class ID extends TurtleCommand{

    public ID (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return Double.parseDouble(getModel().getID().toString());
    }

}
