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
        lines = new ArrayList<LineModel>();
        lastLine = new LineModel(new Position(0, 0), new Position(0, 0));
        lines.add(lastLine);
        penDown = true;
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
