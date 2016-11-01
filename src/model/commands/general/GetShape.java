package model.commands.general;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

public class GetShape extends DisplayCommand{

    public GetShape (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return getModel().getDisplay().getShape();
    }
   

}
