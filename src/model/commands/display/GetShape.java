package model.commands.display;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

/**
 * Command to return the current shape (image) of the turtles
 * @author Brian
 *
 */
public class GetShape extends DisplayCommand{

    public GetShape (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return getModel().getShape();
    }
   

}
