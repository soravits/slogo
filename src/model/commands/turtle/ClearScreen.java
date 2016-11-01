package model.commands.turtle;

import model.Model;

public class ClearScreen extends Home{

    public ClearScreen (double[] parameters, Model model) {
        super(parameters, model);
    }
    
    @Override
    public double execute(){
        getModel().getLineState().clearLine();
        return moveToZero();
    }

}
