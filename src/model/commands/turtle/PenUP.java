package model.commands.turtle;

import model.Model;
import model.commands.Command;

public class PenUP extends Command {

    PenUP (double[] params, Model model) {
        super(params, model);
    }

    @Override
    public double execute (double[] params, Model slogoModel) {
        slogoModel.getLineState().setPenDown(false);
        return 0;
    }

   
}
