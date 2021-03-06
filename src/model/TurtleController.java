package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import model.interfaces.TurtleControllerInterface;

/**
 * Coordinates the current Turtles that are being actively modified as specified by the Tell, Ask, and Ask-With
 * Commands. Able to handle nested Ask commands cleanly. Executor classes call these methods after parsing
 * but before executing individual commands
 * @author Brian
 *
 */
public class TurtleController implements TurtleControllerInterface {

    private boolean isTell;
    private int nestedAsk;
    private Collection<Double> currentTellTurtles;
    private HashMap<Integer, HashSet<Double>> askTurtles;

    public TurtleController(){
        this.isTell = true;
        this.nestedAsk = -1;
        this.currentTellTurtles = new HashSet<Double>();
        currentTellTurtles.add(1.0);
        this.askTurtles = new HashMap<Integer, HashSet<Double>>();
    }

    
    @Override
    public void clearTellTurtles(){
        currentTellTurtles.clear();
    }

    @Override
    public void changeActiveTurtle (double ID){
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
