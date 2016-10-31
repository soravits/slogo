package model.abstractcommands;

import model.Model;
import model.interfaces.DisplayCommandInterface;

public abstract class DisplayCommand extends GeneralCommand{

    private DisplayCommandInterface display;
    
    public DisplayCommand (double[] parameters, Model model) {
        super(parameters);
        display = model;
    }
    
    public DisplayCommandInterface getModel(){
        return display;
    }
    
    @Override
    public abstract double execute () throws Exception;

}
