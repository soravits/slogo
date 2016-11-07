package model.commands.display;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

/**
 * Command to set the current background color to the specified index
 * @author Brian
 *
 */
public class SetBackground extends DisplayCommand{

    public SetBackground (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        this.getModel().setBackGround(this.getParams()[0]);
        return this.getParams()[0];
    }
    

}
