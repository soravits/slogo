package model.interfaces;

import java.util.Collection;
import model.WorkspaceState;

/**
 * Interface used by Control commands to get the necessary access to the variables and TurtleController
 * from the model
 * @author Brian
 *
 */
public interface ControlCommandInterface extends TurtleControllerInterface {

    /**
     * @return workspace of current variables that have been set via commands in the shell
     */
    WorkspaceState getWorkspace ();
    
    /**
     * @return Collection of Turtles that currently exist in the workspace
     */
    Collection<Double> getIDs();

    /**
     * Clear the entire list of current active turtles
     */
    void clearTellTurtles ();
//
//    /**
//     * Add a turtle to the active list
//     * @param ID : ID number of turtle
//     */
//    void addTurtle(double ID);
//
//    /**
//     * @return A collection of the ID's of the current active list of Turtles
//     */
//    Collection<Double> getTurtlesToModify ();
//
//    /**
//     * Add a list of Turtles to be temporarily active during an "Ask" command
//     */
//    void addNestedAsk ();
//
//    /**
//     * Subtract a list of turtles that is no longer active after leaving an "Ask" command
//     */
//    void subtractNestedAsk ();
}