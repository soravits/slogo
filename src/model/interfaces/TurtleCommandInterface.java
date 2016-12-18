package model.interfaces;

import java.util.List;
import model.LineState;
import model.TurtleState;

/**
 * Specifies the methods needed by the Turtle Commands to access the Turtles and Lines in the Model
 * @author Brian
 *
 */
public interface TurtleCommandInterface {

    /**
     * 
     * @return current Turtle specified by the currentID in the TurtleMap
     */
    TurtleState getTurtle();
    
    /**
     * @return current LineState specified by the currentID in the TurtleMap
     */
    LineState getLineState();
    
    /**
     * @return current ID of specified turtle in the TurtleMap
     */
    double getID();
    
    /**
     * @return number of turtles that currently exist in the workspace
     */
    double getNumberOfTurtles();
    
    /**
     * @return current list of stamps in the model
     */
    List<TurtleState> getStamps();

}
