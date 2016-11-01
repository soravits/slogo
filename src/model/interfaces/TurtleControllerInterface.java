package model.interfaces;

import java.util.Collection;

/**
 * Created by Brian on 11/1/2016.
 */
public interface TurtleControllerInterface {

    void removeTellTurtle (double ID);

    void clearTellTurtles ();

    void addTurtle(double ID);

    Collection<Double> getTurtlesToModify ();

    void addNestedAsk ();

    void subtractNestedAsk ();
}
