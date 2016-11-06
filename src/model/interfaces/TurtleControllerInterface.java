package model.interfaces;

import java.util.Collection;

/**
 * Created by Brian on 11/1/2016. Specifies methods used for Executor classes to interact with the Turtle Controller
 */
public interface TurtleControllerInterface {

    /**
     * Change the active state of a particular turtle from active to inactive or inactive to active
     * @param ID
     */
    void changeTurtleActive(double ID);
    
    /**
     * Clear list of actively modified 'Tell' turtles
     */
    void clearTellTurtles ();

    /**
     * Add a turtle to the active list; controller adds it to either Ask or Tell Collections
     * @param ID
     */
    void addTurtle(double ID);

    /**
     * 
     * @return current collection of Turtles to be modified
     */
    Collection<Double> getTurtlesToModify ();

    /**
     * Add a new collection of turtles that is active inside of an Ask command
     */
    void addNestedAsk ();

    /**
     * Subtract a collection of turtles that is now inactive after completing an ask command
     */
    void subtractNestedAsk ();
}
