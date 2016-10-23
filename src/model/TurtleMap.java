package model;

import java.util.HashMap;

public class TurtleMap {

    private Object currentID;
    private HashMap<Object, TurtlePair> turtleMap;
    
    public TurtleMap(){
        currentID = 1;
        turtleMap = new HashMap<Object, TurtlePair>();
    }
    
    public TurtleState getTurtle(){
        return turtleMap.get(currentID).getTurtle();
    }
    
    public TurtleState getTurtle(Object ID){
        currentID = ID;
        return turtleMap.get(currentID).getTurtle();        
    }
    
    public LineState getLineState(){
        return turtleMap.get(currentID).getLines();
    }
    
    public LineState getLineState(Object ID){
        return turtleMap.get(ID).getLines();
    }

    public Object getCurrentID () {
        return currentID;
    }

    public void setCurrentID (Object ID) {
        currentID = ID;
    }
}
