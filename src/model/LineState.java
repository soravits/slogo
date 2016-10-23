package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class LineState implements LineStateInterface {

    private Collection<LineModel> lines;
    private boolean penDown;
    
    public LineState(){
        lines = new HashSet<LineModel>();
        penDown = true;
    }

    @Override
    public void createLine (Position pos1, Position pos2) {
        if (penDown == true){
            lines.add(new LineModel(pos1, pos2));
        }
    }

    @Override
    public Iterator<LineModel> getLines () {
        return lines.iterator();
    }

    @Override
    public void clearLine () {
        lines.clear();
    }

    public boolean isPenDown () {
        return penDown;
    }

    public void setPenDown (boolean penDown) {
        this.penDown = penDown;
    }    
}
