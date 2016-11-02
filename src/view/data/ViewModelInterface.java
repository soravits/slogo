package view.data;

import java.util.Collection;

import model.TurtleMap;
import model.WorkspaceState;

public interface ViewModelInterface{
    
	public TurtleMap getTurtleMap();
	
    public WorkspaceState getWorkspace ();
    
    public Collection<String> getCommandHistory();
    
    public Collection<String> getConsoleReturn();
    
    public Collection<Double> getIDs();
    
    public boolean getShowTurtle(double id);
    
    public double getTurtleAngle(double id);
    
    public double getTurtleX(double id);
    
    public double getTurtleY(double id);
    
    public boolean isPenDown(double id);
    
    public void changeActiveTurtle(double ID);
    
    public double[][] getLines (double ID);
    
    public Collection<Double> getTurtlesToModify();
    
}
