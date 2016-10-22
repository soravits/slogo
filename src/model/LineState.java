package model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class LineState implements LineStateInterface {

    private Collection<LineModel> lines;
    
    public LineState(){
        lines = new HashSet<LineModel>();
    }

    @Override
    public void createLine (Position pos1, Position pos2) {
        lines.add(new LineModel(pos1, pos2));
    }

    @Override
    public Iterator<LineModel> getLines () {
        return lines.iterator();
    }

    @Override
    public void clearLine () {
        lines.clear();
    }    
}
