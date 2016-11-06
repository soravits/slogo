package model.abstractcommands;

import model.interfaces.DisplayCommandInterface;

/**
 * The model interface used for Display commands it the DisplayCommandInterface, which only gives these commands
 * access to the displayState instance of the model for manipulation
 * @author Brian
 *
 */
public abstract class DisplayCommand extends GeneralCommand{

    private DisplayCommandInterface display;
    
    public DisplayCommand (double[] parameters, DisplayCommandInterface model) {
        super(parameters);
        display = model;
    }
    
    /**
     * @return DisplayCommandInterface of the model
     */
    public DisplayCommandInterface getModel(){
        return display;
    }
    
    @Override
    public abstract double execute () throws Exception;

}
