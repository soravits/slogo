package model.commands.turtle;

import model.interfaces.TurtleCommandInterface;

/**
 * Clear the entire GUI window of all turtles and lines; reset Turtle with ID # 1 to the Home location
 * @author Brian
 *
 */
public class ClearScreen extends Home{

    public ClearScreen (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
    }
    
    @Override
    public double execute(){
        this.getModel().getLineState().clearLine();
        return moveToZero();
    }

}
