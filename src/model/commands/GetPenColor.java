package model.commands;

import model.Model;
import model.abstractcommands.DisplayCommand;

public class GetPenColor extends DisplayCommand{

    public GetPenColor (double[] parameters, Model model) {
        super(parameters, model);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () throws Exception {
        return getModel().getDisplay().getPenColor();
    }

}
