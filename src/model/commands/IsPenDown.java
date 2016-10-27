package model.commands;

import model.Model;
import model.abstractcommands.Command;

public class IsPenDown extends Command{

    public IsPenDown (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () throws Exception {
        return (getModel().getLineState().isPenDown()) ? 1 : 0;
    }

}
