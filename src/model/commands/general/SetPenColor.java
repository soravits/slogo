package model.commands.general;

import model.Model;
import model.abstractcommands.DisplayCommand;

public class SetPenColor extends DisplayCommand{

    public SetPenColor (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        getModel().getDisplay().setPenColor(this.getParams()[0]);
        return this.getParams()[0];
    }

}
