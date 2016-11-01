package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TurtleController {
    
    private boolean isTell;
    private int nestedAsk;
    private Collection<Object> currentTellTurtles;
    private HashMap<Integer, ArrayList<Object>> askTurtles;
    
    public TurtleController(){
        isTell = true;
        nestedAsk = 0;
        currentTellTurtles = new ArrayList<Object>(1);
        askTurtles = new HashMap<Integer, ArrayList<Object>>();
    }
    
    public void addTellTurtle(Object ID){
        currentTellTurtles.add(ID);
    }
    
    public void clearTellTurtles(){
        currentTellTurtles.clear();
    }
    
    public void addAskTurtle(Object ID){
        askTurtles.get(nestedAsk).add(ID);
    }
    
    public Collection<Object> getTurtlesToModify(){
        if (isTell){
            return currentTellTurtles;
        }
        return askTurtles.get(nestedAsk);
    }
    
    public void addNestedAsk(){
        nestedAsk += 1;
    }
    
    public void subtractNestedAsk(){
        nestedAsk -= 1;
    }
    
}
