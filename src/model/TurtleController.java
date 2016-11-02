package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import model.interfaces.TurtleControllerInterface;

public class TurtleController implements TurtleControllerInterface {

    private boolean isTell;
    private int nestedAsk;
    private Collection<Double> currentTellTurtles;
    private HashMap<Integer, HashSet<Double>> askTurtles;

    public TurtleController(){
        isTell = true;
        nestedAsk = -1;
        currentTellTurtles = new HashSet<Double>();
        currentTellTurtles.add(1.0);
        askTurtles = new HashMap<Integer, HashSet<Double>>();
    }

    @Override
    public void removeTellTurtle(double ID){
        currentTellTurtles.remove(ID);
    }

    @Override
    public void clearTellTurtles(){
        currentTellTurtles.clear();
    }

    public void changeTurtleActive (double ID){
        if (currentTellTurtles.contains(ID)){
            currentTellTurtles.remove(ID);
        }
        else{
            currentTellTurtles.add(ID);
        }
    }
    
    
    @Override
    public void addTurtle(double ID){
            if (isTell) {
                currentTellTurtles.add(ID);
            } else {
                askTurtles.get(nestedAsk).add(ID);
            }
    }
    
    @Override
    public Collection<Double> getTurtlesToModify(){
        if (isTell){
            return currentTellTurtles;
        }
        return askTurtles.get(nestedAsk);
    }

    @Override
    public void addNestedAsk(){
        isTell = false;
        nestedAsk += 1;
        HashSet<Double> turtles = new HashSet<Double>();
        askTurtles.put(nestedAsk, turtles);
    }

    @Override
    public void subtractNestedAsk(){
        nestedAsk -= 1;
        if (nestedAsk == -1){
            isTell = true;
        }
    }

}
