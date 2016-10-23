package model;

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

    public void setLines (LineState lineState) {
        lines = lineState;
    }

    public TurtleState getTurtle () {
        return turtle;
    }

    public void setTurtle (TurtleState turtleState) {
        turtle = turtleState;
    }
    
    

}
