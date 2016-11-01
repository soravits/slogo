package model.commands;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

public class SetShape extends DisplayCommand{

    public SetShape (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        getModel().getDisplay().setShape(this.getParams()[0]);
        return this.getParams()[0];
    }

}
