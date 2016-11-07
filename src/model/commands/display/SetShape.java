package model.commands.display;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

/**
 * Command to set the image/shape to the specified index
 * @author Brian
 *
 */
public class SetShape extends DisplayCommand{

    public SetShape (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        this.getModel().setShape(this.getParams()[0]);
        return this.getParams()[0];
    }

}
