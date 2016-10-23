package model;

import java.util.Iterator;
import java.util.List;

/**
 * The interface implemented by the LineState class; used to update the state of the line after
 * receiving a command, as well as get the individual characteristics of a line
 * @author Brian
 *
 */
public interface LineStateInterface {

    /**
     * Create line from position 1 to position 2 and add it to the Collection of Lines
     * @param pos1
     * @param pos2
     */
    public void createLine(Position pos1, Position pos2);
    
    /**
     * return Iterator for each line
     */
    public Iterator<LineModel> getLines();
    
    /**
     * Clear all of the points from the line
     */
    public void clearLine();
    
   /**
    * @return the current state of the pen. If pen is down, lines are being written
    */
    public boolean isPenDown();
    
    /**
     * Set the current state of the pen. Determines whether or not to draw lines
     * @param penDown
     */
    public void setPenDown(boolean penDown);
    
}
