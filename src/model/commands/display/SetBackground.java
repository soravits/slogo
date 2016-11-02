package model.commands.display;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

public class SetBackground extends DisplayCommand{

    public SetBackground (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        getModel().setBackGround(this.getParams()[0]);
        return this.getParams()[0];
    }
    

}
