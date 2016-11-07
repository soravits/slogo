package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 * A collection of IDs and their associated TurtleState/LineState. CurrentID is used to set the current
 * turtle that the map is operating on; working together with the Turtle Controller, the correct turtles
 * are manipulated via the specified turtle commands. 
 * @author Brian
 *
 */
public class TurtleMap {

    private double currentID;
    private Map<Double, TurtlePair> turtleMap;
    
    public TurtleMap(){
        this.currentID = 1.0;
        this.turtleMap = new HashMap<Double, TurtlePair>();
        TurtlePair firstPair = new TurtlePair();
        turtleMap.put(currentID, firstPair);
    }
    
    /**
     * Add a turtle (at origin) with ID to the collection of turtles
     * @param ID
     */
    public void addTurtle (Double ID){
        if (!turtleMap.containsKey(ID)){
            TurtlePair turtle = new TurtlePair();
            turtleMap.put(ID, turtle);
        }
    }
    
    /**
     * 
     * @return Collection of all current Turtle ID's in the Map
     */
    public Collection<Double> getIDs(){
    	return turtleMap.keySet();
    }
    
    /**
     * 
     * @return current TurtleState associated with currentID
     */
    public TurtleState getTurtle(){
        return turtleMap.get(currentID).getTurtle();
    }

    /**
     * @param ID
     * @return the specific turtle associated with an input ID; used by the front-end when looping
     * through each turtle
     */
    public TurtleState getTurtle(double ID){
        return turtleMap.get(ID).getTurtle();
    }
    
    /**
     * 
     * @param ID
     * @return the most recently drawn line for each turtle. Double array is in form of [x1 y1][x2 y2]
     */
    public double[][] getLines(double ID) {
        return turtleMap.get(ID).getLines().getLastLineDrawn();
    }
    
    /**
     * @return the LineState associated with the turtle of ID currentID
     */
    public LineState getLineState(){
        return turtleMap.get(currentID).getLines();
    }

    /**
     * 
     * @param ID
     * @return LineState for turtle at specified ID
     */
    public LineState getLineState(double ID){
        return turtleMap.get(ID).getLines();
    }
    
    /**
     * 
     * @return the current ID of the turtle being selected in the Map
     */
    public double getCurrentID () {
        return currentID;
    }

    /**
     * Change the currentID value to ID
     * @param ID
     */
    public void setCurrentID (double ID) {
        currentID = ID;
    }
    
    /**
     * Clear the current TurtleMap, reinstantiate the first turtle at (0, 0)
     */
    public void clear(){
        turtleMap.clear();
        TurtlePair firstPair = new TurtlePair();
        turtleMap.put(1.0, firstPair);
    }
}
