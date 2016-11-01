package model.commands.general;

import model.Model;
import model.abstractcommands.TurtleCommand;

public class ID extends TurtleCommand{

    public ID (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return Double.parseDouble(getModel().getID().toString());
    }

}
