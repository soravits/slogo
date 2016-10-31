package model.abstractcommands;

import model.Model;
import model.interfaces.TurtleCommandInterface;

public abstract class TurtleCommand extends GeneralCommand implements CommandInterface {

    private TurtleCommandInterface turtleModel;
    
    public TurtleCommand(double[] parameters, Model model){
        super(parameters);
        turtleModel = model;
    }
    
    public TurtleCommandInterface getModel(){
        return turtleModel;
    }
    
    public abstract double execute () throws Exception;

    public double normalizeAngle(double angle){
        double normalizedAngle = angle % 360;
        if (normalizedAngle < 0){
            normalizedAngle += 360;
        }
        return normalizedAngle;
    }
}
