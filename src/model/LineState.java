package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The class implements the way in which LinesModels are saved/updated; used to update the state of the line after
 * receiving a command, as well as get the individual characteristics of a line
 * @author Brian
 *
 */
public class LineState {

    private List<LineModel> lines;
    private boolean penDown;
    private LineModel lastLine;
    
    public LineState(){
        clearLine();
        this.penDown = true;
    }

    /**
     * Create line from position 1 to position 2 and add it to the Collection of Lines
     * @param pos1
     * @param pos2
     */
    public void createLine (Position pos1, Position pos2) {
        if (penDown == true){
            LineModel line = new LineModel(pos1, pos2);
            lines.add(line);
        }
    }

    /**
     * 
     * @return a 2x2 array of the points of the last line drawn. The format is [x1 y1][x2 y2], where x1
     * and y1 are the x and y of the first point, and x2, y2 are the x and y coordinate of the point you
     * are drawing the line to
     */
    public double[][] getLastLineDrawn(){
    	if (lastLine.equals(lines.get(lines.size() - 1))){
    		LineModel lineToDraw = new LineModel(lastLine.getPosition2(), lastLine.getPosition2());
    		return lineToDraw.getLine();
    	}
    	lastLine = lines.get(lines.size() - 1);
        return lines.get(lines.size() - 1).getLine();
    }
    
    /**
     * Clear all of the points from the line
     */
    public void clearLine () {
        this.lines = new ArrayList<LineModel>();
        this.lastLine = new LineModel(new Position(0, 0), new Position(0, 0));
        lines.add(lastLine);
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
