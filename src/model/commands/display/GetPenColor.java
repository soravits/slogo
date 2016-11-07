package model.commands.display;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

/**
 * Command to return the current pen color
 * @author Brian
 *
 */
public class GetPenColor extends DisplayCommand{

    public GetPenColor (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return this.getModel().getPenColor();
    }

}
