package model.commands;

import model.Model;
import model.abstractcommands.DisplayCommand;

public class SetBackground extends DisplayCommand{

    public SetBackground (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        getModel().getDisplay().setBackGround(this.getParams()[0]);
        return this.getParams()[0];
    }

}
