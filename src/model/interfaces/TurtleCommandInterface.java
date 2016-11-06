package model.interfaces;

import model.LineState;
import model.TurtleState;

public interface TurtleCommandInterface {

    /**
     * 
     * @return current Turtle specified by the currentID in the TurtleMap
     */
    public TurtleState getTurtle();
    
    /**
     * @return current LineState specified by the currentID in the TurtleMap
     */
    public LineState getLineState();
    
    /**
     * @return current ID of specified turtle in the TurtleMap
     */
    public double getID();
    
    /**
     * @return
     */
    public double getNumberOfTurtles();

}
