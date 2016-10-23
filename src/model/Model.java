package model;

public class Model{

    private TurtleState turtle;
    private LineState lines;
    private WorkspaceState workspace;
    private CommandHistory commandHistory;

    public Model(){
        turtle = new TurtleState();
        lines = new LineState();
        workspace = new WorkspaceState();
        commandHistory = new CommandHistory();
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
    
    public CommandHistory getCommandHistory() {
        return commandHistory;
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
    
    public void setCommandHistory (CommandHistory commands){
        commandHistory = commands;
    }
    


    
}
