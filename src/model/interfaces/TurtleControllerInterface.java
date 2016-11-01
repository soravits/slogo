package model.interfaces;

import java.util.Collection;


public interface TurtleControllerInterface {

    void removeTellTurtle (Object ID);

    void clearTellTurtles ();

    void addTurtle(Object ID);

    Collection<Object> getTurtlesToModify ();

    void addNestedAsk ();

    void subtractNestedAsk ();

}
