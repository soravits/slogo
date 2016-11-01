package model.interfaces;

import model.LineState;
import model.TurtlePair;
import model.WorkspaceState;

import java.util.Collection;

/**
 * Created by Soravit on 11/1/2016.
 */
public interface ControlCommandInterface {

    public WorkspaceState getWorkspace ();

    void removeTellTurtle (double ID);

    void clearTellTurtles ();

    void addTurtle(double ID);

    Collection<Double> getTurtlesToModify ();

    void addNestedAsk ();

    void subtractNestedAsk ();

}