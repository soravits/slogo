package model;

public class Model{

    private TurtleState turtle;
    private LineState lines;
    private WorkspaceState workspace;

    public Model(TurtleState turtleState, LineState lineState, WorkspaceState workspaceState){
        turtle = turtleState;
        lines = lineState;
        workspace = workspaceState;
    }

    public TurtleState getTurtle () {
        return turtle;
    }
    public LineState getLineState () {
        return lines;
    }
    public WorkspaceState getWorkspace () {
        return workspace;
    }

    public void setTurtle (TurtleState turtleState) {
        turtle = turtleState;
    }

    public void setLines (LineState lineState) {
        lines = lineState;
    }

    public void setWorkspace (WorkspaceState workspaceState) {
        workspace = workspaceState;
    }
    


    
}
