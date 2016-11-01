package model.commands.turtle;

import model.interfaces.TurtleCommandInterface;

public class ClearScreen extends Home{

    public ClearScreen (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }
    
    @Override
    public double execute(){
        getModel().getLineState().clearLine();
        return moveToZero();
    }

}
