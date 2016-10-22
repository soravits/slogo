package model;

import javafx.beans.property.SimpleObjectProperty;

public class Model{

    private SimpleObjectProperty<TurtleState> turtle;
    private SimpleObjectProperty<LineState> lines;
    private SimpleObjectProperty<WorkspaceState> workspace;

    public Model(TurtleState turtleState, LineState lineState, WorkspaceState workspaceState){
        turtle = new SimpleObjectProperty<TurtleState>(turtleState);
        lines = new SimpleObjectProperty<LineState>(lineState);
        workspace = new SimpleObjectProperty<WorkspaceState>(workspaceState);
    }

    public TurtleState getModifiableTurtle () {
        return turtle.getValue();
    }
    public LineState getModifiableLineState () {
        return lines.getValue();
    }
    public WorkspaceState getModifiableWorkspace () {
        return workspace.getValue();
    }
    
    public TurtleState getTurtle () {
        return turtle.get();
    }
    public LineState getLineState () {
        return lines.get();
    }
    public WorkspaceState getWorkspace () {
        return workspace.get();
    }
    


    
}
