package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The class implements the way in which LinesModels are saved/updated; used to update the state of the line after
 * receiving a command, as well as get the individual characteristics of a line
 * @author Brian
 *
 */
public class LineState {

    private Collection<LineModel> lines;
    private boolean penDown;
    
    public LineState(){
        lines = new HashSet<LineModel>();
        penDown = true;
    }

    /**
     * Create line from position 1 to position 2 and add it to the Collection of Lines
     * @param pos1
     * @param pos2
     */
    public void createLine (Position pos1, Position pos2) {
        if (penDown == true){
            lines.add(new LineModel(pos1, pos2));
        }
    }

    /**
     * return Iterator for each line
     */
    public Collection<LineModel> getLines () {
        return lines;
    }

    /**
     * Clear all of the points from the line
     */
    public void clearLine () {
        lines.clear();
    }

    /**
     * @return the current state of the pen. If pen is down, lines are being written
     */
    public boolean isPenDown () {
        return penDown;
    }

    /**
     * Set the current state of the pen. Determines whether or not to draw lines
     * @param penDown
     */
    public void setPenDown (boolean penDown) {
        this.penDown = penDown;
    }    
}
