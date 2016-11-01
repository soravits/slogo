package model.commands;

import model.Model;
import model.abstractcommands.DisplayCommand;

public class SetPenSize extends DisplayCommand{

    public SetPenSize (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        getModel().getDisplay().setPenSize(this.getParams()[0]);
        return this.getParams()[0];
    }

}
