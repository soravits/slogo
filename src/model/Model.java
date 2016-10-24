package model;

import java.util.Collection;

public class Model{

    private TurtleMap turtleMap;
    private WorkspaceState workspace;
    private CommandHistory commandHistory;

    public Model(){
        turtleMap = new TurtleMap();
        workspace = new WorkspaceState();
        commandHistory = new CommandHistory();
    }

    public TurtleMap getTurtleMap (){
        return turtleMap;
    }
    
    public TurtleState getTurtle () {
        return turtleMap.getTurtle();
    }
    public TurtleState getTurtle (Object ID){
        return turtleMap.getTurtle(ID);
    }
    
    public LineState getLineState () {
        return turtleMap.getLineState();
    }
    
    public LineState getLineState (Object ID){
        return turtleMap.getLineState(ID);
    }
    
    public WorkspaceState getWorkspace () {
        return workspace;
    }
    
    public Collection<String> getCommandHistory() {
        return commandHistory.getCommandHistory();
    }
}
