package model.commands;

import model.Model;
import model.abstractcommands.DisplayCommand;

public class GetShape extends DisplayCommand{

    public GetShape (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return getModel().getDisplay().getShape();
    }
   

}
