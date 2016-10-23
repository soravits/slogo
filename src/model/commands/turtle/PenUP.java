package model.commands.turtle;

import model.Model;
import model.commands.Command;

public class PenUP extends Command {

    PenUP (Model model) {
        super(model);
    }

    @Override
    public double execute () {
        this.getModel().getLineState().setPenDown(false);
        return 0;
    }

   
}
