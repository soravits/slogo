package model.interfaces;

import model.WorkspaceState;

import java.util.Collection;

/**
 * Created by Soravit on 11/1/2016.
 */
public interface ControlCommandInterface {

    public WorkspaceState getWorkspace ();

    void removeTellTurtle (Object ID);

    void clearTellTurtles ();

    void addTurtle(Object ID);

    Collection<Object> getTurtlesToModify ();

    void addNestedAsk ();

    void subtractNestedAsk ();
}
