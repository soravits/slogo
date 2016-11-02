package model.commands.display;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

public class SetPenSize extends DisplayCommand{

    public SetPenSize (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        getModel().setPenSize(this.getParams()[0]);
        return this.getParams()[0];
    }

}