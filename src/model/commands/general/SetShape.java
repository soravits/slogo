package model.commands.general;

import model.Model;
import model.abstractcommands.DisplayCommand;

public class SetShape extends DisplayCommand{

    public SetShape (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        getModel().getDisplay().setShape(this.getParams()[0]);
        return this.getParams()[0];
    }

}
