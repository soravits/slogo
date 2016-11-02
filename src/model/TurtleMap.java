package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TurtleMap {

    private double currentID;
    private Map<Double, TurtlePair> turtleMap;
    
    public TurtleMap(){
        currentID = 1.0;
        turtleMap = new HashMap<Double, TurtlePair>();
        TurtlePair firstPair = new TurtlePair();
        turtleMap.put(currentID, firstPair);
    }
    
    public void addTurtle (Double ID){
        for(Double o : turtleMap.keySet()){
            //System.out.println(o);
        }
        if (!turtleMap.containsKey(ID)){
            //System.out.println(ID);
            TurtlePair turtle = new TurtlePair();
            turtleMap.put(ID, turtle);
        }
    }
    
    public Collection<Double> getIDs(){
    	return turtleMap.keySet();
    }
    
    public Collection<TurtlePair> getTurtles(){
        return turtleMap.values();
    }
    
    public TurtleState getTurtle(){
        return turtleMap.get(currentID).getTurtle();
    }

    public TurtleState getTurtle(double ID){
        //currentID = ID;
        return turtleMap.get(ID).getTurtle();
    }
    
    // TELL DIANE TO CALL THIS METHOD!!!!
    public double[][] getLines(double ID) {
        return turtleMap.get(ID).getLines().getLastLineDrawn();
    }
//    public Collection<LineModel> getLines(){
//        return turtleMap.get(currentID).getLines().getLines();
//    }
    
    public LineState getLineState(){
        return turtleMap.get(currentID).getLines();
    }
    
    public LineState getLineState(double ID){
        return turtleMap.get(ID).getLines();
    }

    public double getCurrentID () {
        return currentID;
    }

    public void setCurrentID (double ID) {
        currentID = ID;
    }
    
    public void clear(){
        turtleMap.clear();
        TurtlePair firstPair = new TurtlePair();
        turtleMap.put(1.0, firstPair);
    }
}