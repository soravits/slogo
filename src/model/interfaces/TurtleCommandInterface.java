package model.interfaces;

import model.LineState;
import model.TurtleState;

public interface TurtleCommandInterface {

    public TurtleState getTurtle();
    
    public LineState getLineState();
    
    public Object getID();
    
    public double getNumberOfTurtles();
}
