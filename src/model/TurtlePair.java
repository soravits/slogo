package model;

/**
 * This class is used to package a Turtle with its LineState. It was created to allow for the TurtleState
 * and LineState to be separate classes and yet still be mapped together to form an ID. However, this class
 * does not currently provide much value to the design of the program. 
 * @author Brian
 *
 */
public class TurtlePair {
    
    private LineState lines;
    private TurtleState turtle;
    
    public TurtlePair(){
        turtle = new TurtleState();
        lines = new LineState();
    }

    /**
     * 
     * @return the LineState associated with a turtle pair
     */
    public LineState getLines () {
        return lines;
    }

    /**
     * 
     * @return the TurtleState associated with a turtle pair
     */
    public TurtleState getTurtle () {
        return turtle;
    }
}
