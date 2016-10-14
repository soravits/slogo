package model;

import java.util.List;

/**
 * The interface implemented by the LineState class; used to update the state of the line after
 * receiving a command, as well as get the individual characteristics of a line
 * @author Brian
 *
 */
public interface LineStateInterface {

    /*
     * Change the styling of the line
     */
    public void changeLineType(Object lineType);
    
    /*
     * Add the current position of the turtle to the linked list of connected points
     */
    public void addPointToLine(Position currentPosition);
    
    /*
     * Remove a position from the line if the 
     */
    public void removePointFromLine(Position position);
    
    /*
     * Clear all of the points from the line
     */
    public void clearLine();
    
    /*
     * Get the current list of points that the line must travel through
     */
    public List<Position> getLinePoints();
}
