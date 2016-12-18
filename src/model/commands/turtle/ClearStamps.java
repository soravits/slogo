package model.commands.turtle;

import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class ClearStamps extends TurtleCommand{

    public ClearStamps (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        int returnValue = this.getModel().getStamps().size();
        this.getModel().getStamps().clear();
        if (returnValue == 0){
            return 0;
        };
        return 1;
    }

}
