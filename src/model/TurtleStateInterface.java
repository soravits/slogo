package model;

/**
 * The interface implemented by the TurtleState class; used to update the state of the turtle after
 * receiving a command, as well as get the individual characteristics of a turtle
 * @author Brian
 *
 */
public interface TurtleStateInterface {

    /*
     * Set the new value of the Turtle's X-coordinate
     */
    public void setTurtleX(Number x);
    
    /*
     * Set the new value of the Turtle's Y-coordinate
     */
    public void setTurtleY(Number y);
    
    /*
     * Set the new angle of the Turtle
     */
    public void setTurtleAngle(Number degree);
    
    /*
     * Change whether or not you currently see the turtle in the GUI
     */
    public void setShowTurtle(boolean setShow);

    /*
     * Get the turtle's current X-coordinate
     */
    public Number getTurtleX();
    
    /*
     * Get the turtle current Y-coordinate
     */
    public Number getTurtleY();
    
    /*
     * Get the current heading of the turtle
     */
    public Number getTurtleAngle();
    
    /*
     * Determine if the GUI should display the turtle
     */
    public boolean getShowTurtle();
    
    /*
     * Return the distance that the turtle has moved
     */
    public Number getTurtleDistance();
}
