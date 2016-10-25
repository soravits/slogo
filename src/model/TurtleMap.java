package model;

import java.util.Collection;
import java.util.HashMap;

public class TurtleMap {

    private Object currentID;
    private HashMap<Object, TurtlePair> turtleMap;
    
    public TurtleMap(){
        currentID = 1;
        turtleMap = new HashMap<Object, TurtlePair>();
        TurtlePair firstPair = new TurtlePair();
        turtleMap.put(currentID, firstPair);
    }
    
    public Collection<TurtlePair> getTurtles(){
        return turtleMap.values();
    }
    
    public TurtleState getTurtle(){
        return turtleMap.get(currentID).getTurtle();
    }
    
    public TurtleState getTurtle(Object ID){
        currentID = ID;
        return turtleMap.get(currentID).getTurtle();        
    }
    
    public Collection<LineModel> getLines(){
        return turtleMap.get(currentID).getLines().getLines();
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
    
    public void clear(){
    	turtleMap.clear();
    }
}
