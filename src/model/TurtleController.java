package model;

import java.util.ArrayList;
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
        currentTellTurtles = new ArrayList<Double>();
        currentTellTurtles.add(1.0);
        askTurtles = new HashMap<Integer, HashSet<Double>>();
    }

    /* (non-Javadoc)
     * @see controller.TurtleControllerInterface#removeTellTurtle(java.lang.Object)
     */
    @Override
    public void removeTellTurtle(double ID){
        currentTellTurtles.remove(ID);
    }

    /* (non-Javadoc)
     * @see controller.TurtleControllerInterface#clearTellTurtles()
     */
    @Override
    public void clearTellTurtles(){
        currentTellTurtles.clear();
    }

    public void clearAskTurtles(){
        askTurtles.get(nestedAsk).clear();
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
    /* (non-Javadoc)
     * @see controller.TurtleControllerInterface#getTurtlesToModify()
     */
    @Override
    public Collection<Double> getTurtlesToModify(){
        if (isTell){
            return currentTellTurtles;
        }
        return askTurtles.get(nestedAsk);
    }

    /* (non-Javadoc)
     * @see controller.TurtleControllerInterface#addNestedAsk()
     */
    @Override
    public void addNestedAsk(){
        nestedAsk += 1;
        HashSet<Double> turtles = new HashSet<Double>();
        askTurtles.put(nestedAsk, turtles);
    }

    /* (non-Javadoc)
     * @see controller.TurtleControllerInterface#subtractNestedAsk()
     */
    @Override
    public void subtractNestedAsk(){
        nestedAsk -= 1;
    }

    public boolean isTell() {
        return isTell;
    }

    public void setTell(boolean tell) {
        isTell = tell;
    }
}
