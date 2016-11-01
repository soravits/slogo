package model.commands;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

public class GetPenColor extends DisplayCommand{

    public GetPenColor (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return getModel().getDisplay().getPenColor();
    }

}
