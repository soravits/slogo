package model.commands.turtle;

import model.Position;
import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

/**
 * Command to send the current turtle back to the origin; returns 1
 * @author Brian
 *
 */
public class Home extends TurtleCommand{

    public Home (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        return moveToZero();
    }
    
    public double moveToZero(){
        Position pos1 = getModel().getTurtle().getPosition().clone();
        double distance = pos1.distance(0, 0);
        getModel().getTurtle().setTurtlePosition(0, 0);
        return distance;
    }
}
