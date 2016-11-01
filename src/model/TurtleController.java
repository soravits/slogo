package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import model.interfaces.TurtleControllerInterface;

public class TurtleController implements TurtleControllerInterface {

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

    /* (non-Javadoc)
     * @see controller.TurtleControllerInterface#removeTellTurtle(java.lang.Object)
     */
    @Override
    public void removeTellTurtle(Object ID){
        currentTellTurtles.remove(ID);
    }

    /* (non-Javadoc)
     * @see controller.TurtleControllerInterface#clearTellTurtles()
     */
    @Override
    public void clearTellTurtles(){
        currentTellTurtles.clear();
    }


    @Override
    public void addTurtle(Object ID){
        if (isTell){
            currentTellTurtles.add(ID);
        }
        else{
            askTurtles.get(nestedAsk).add(ID);
        }
    }
    /* (non-Javadoc)
     * @see controller.TurtleControllerInterface#getTurtlesToModify()
     */
    @Override
    public Collection<Object> getTurtlesToModify(){
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
    }

    /* (non-Javadoc)
     * @see controller.TurtleControllerInterface#subtractNestedAsk()
     */
    @Override
    public void subtractNestedAsk(){
        nestedAsk -= 1;
    }

}
