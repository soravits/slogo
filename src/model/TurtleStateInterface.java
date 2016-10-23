package model;

/**
 * The interface implemented by the TurtleState class; used to update the state of the turtle after
 * receiving a command, as well as get the individual characteristics of a turtle
 * @author Brian
 *
 */
public interface TurtleStateInterface {

    /**
     * Set the new value of the Turtle's X-coordinate
     */
    public void setTurtleX(double x);
    
    /**
     * Add x value to Turtle's current X-coordinate
     */
    public void addTurtleX(double x);
    
    /**
     * Set the new value of the Turtle's Y-coordinate
     */
    public void setTurtleY(double y);
    
    /**
     * Add y value to Turtle's current Y-coordinate
     */
    public void addTurtleY(double y);
    
    /**
     * Set the new angle of the Turtle
     */
    public void setTurtleAngle(double degrees);
    
    /**
     * Add to previous angle of the Turtle
     */
    public void addTurtleAngle(double degrees);
    
    /**
     * Change whether or not you currently see the turtle in the GUI
     */
    public void setShowTurtle(boolean setShow);

    /**
     * get turtle's current X-coordinate
     * @return X-coordinate
     */
    public double getTurtleX();
    
    /**
     * get turtle's current Y-coordinate
     * @return Y-coordinate
     */
    public double getTurtleY();
    
    /**
     * Get the current heading of the turtle
     * @return angle that turtle is currently facing
     */
    public double getTurtleAngle();
    
    /**
     * Determine if the GUI should display the turtle
     * @return true if turtle should be displayed
     */
    public boolean getShowTurtle();
    
    
}
