package model.commands.display;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

/**
 * Command to set the pen color to the specified index
 * @author Brian
 *
 */
public class SetPenColor extends DisplayCommand{

    public SetPenColor (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        this.getModel().setPenColor(this.getParams()[0]);
        return this.getParams()[0];
    }

}
