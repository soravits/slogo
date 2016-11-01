package view.data;

import java.util.Collection;
import model.TurtleMap;
import model.WorkspaceState;

public interface ViewModelInterface{
    public TurtleMap getTurtleMap();
    
    public WorkspaceState getWorkspace ();
    
    public Collection<String> getCommandHistory();
    
    public Collection<String> getConsoleReturn();
    
}
