package model;

import java.util.Iterator;

public class TurtlePair {
    
    private LineState lines;
    private TurtleState turtle;
    
    public TurtlePair(){
        turtle = new TurtleState();
        lines = new LineState();
    }

    public LineState getLines () {
        return lines;
    }

    public TurtleState getTurtle () {
        return turtle;
    }
}
