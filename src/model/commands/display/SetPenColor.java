package model.commands.display;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

public class SetPenColor extends DisplayCommand{

    public SetPenColor (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        getModel().setPenColor(this.getParams()[0]);
        return this.getParams()[0];
    }

}
