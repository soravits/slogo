package view.data;

import java.util.Collection;

import model.DisplayState;
import model.TurtleMap;
import model.WorkspaceState;

public interface ViewModelInterface{
	
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
    
    public DisplayState getDisplay();
    
    public double getBackGround ();
    
    public void setBackGround (double back);
    
    public double getPenColor ();
    
    public void setPenColor (double pencolor);
    
    public double getPenSize ();
    
    public void setPenSize (double pensize);

    public double getPaletteIndex ();

    public void setPaletteIndex (double paletteindex);

    public double getShape ();
    
    public void setShape (double shp);

    public int[][] getPaletteColors ();

    public void setPaletteColors (int index, int[] paletteColor);
    
    
}
