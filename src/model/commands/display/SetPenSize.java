package model.commands.display;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

/**
 * Command to set the current pen size to the specified pixel width
 * @author Brian
 *
 */
public class SetPenSize extends DisplayCommand{

    public SetPenSize (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        this.getModel().setPenSize(this.getParams()[0]);
        return this.getParams()[0];
    }

}
