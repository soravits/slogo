package view.data;

import java.util.Collection;

import model.TurtleMap;
import model.WorkspaceState;

public interface ViewModelInterface{
    
	public TurtleMap getTurtleMap();
	
    public WorkspaceState getWorkspace ();
    
    public Collection<String> getCommandHistory();
    
    public Collection<String> getConsoleReturn();
    
    public Collection<Object> getIDs();
    
    public boolean getShowTurtle(Object id);
    
    public double getTurtleAngle(Object id);
    
    public double getTurtleX(Object id);
    
    public double getTurtleY(Object id);
    
    public boolean isPenDown(Object id);
    
}
