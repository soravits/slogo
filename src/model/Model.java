package model;
import java.util.ArrayList;
import java.util.Collection;

import view.data.ViewModelInterface;
import model.interfaces.DisplayCommandInterface;
import model.interfaces.EmptyInterface;
import model.interfaces.TurtleCommandInterface;
import model.interfaces.WorkspaceCommandInterface;

public class Model implements TurtleCommandInterface, WorkspaceCommandInterface, EmptyInterface, DisplayCommandInterface, ViewModelInterface{

    private DisplayState display;
    private TurtleMap turtleMap;
    private WorkspaceState workspace;
    private CommandHistory commandHistory;
    private Collection<String> consoleReturn;

    public Model(){
        display = new DisplayState();
        turtleMap = new TurtleMap();
        workspace = new WorkspaceState();
        commandHistory = new CommandHistory();
        consoleReturn = new ArrayList<String>();
    }

    public TurtleMap getTurtleMap (){
        return turtleMap;
    }
    
    public double getNumberOfTurtles (){
        return turtleMap.getIDs().size();
    }
    
    @Override
    public TurtleState getTurtle () {
        return turtleMap.getTurtle();
    }

    public TurtleState getTurtle (Object ID){
        return turtleMap.getTurtle(ID);
    }
    
    public Object getID () {
        return turtleMap.getCurrentID();
    }
    
    public void setTurtle (Object ID){
        turtleMap.setCurrentID(ID);
    }
    
    public void createTurtle (Object ID){
        turtleMap.addTurtle(ID);
    }
    
    @Override
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
    
    public void addCommand(String command){
        commandHistory.addCommand(command);
    }
    
    public Collection<String> getConsoleReturn(){
        return consoleReturn;
    }
    
    @Override
    public DisplayState getDisplay () {
        return display;
    }

    public void updateConsoleReturn(Double value){
        consoleReturn.add(value.toString());
    }
    
    public void clearConsoleReturn(){
        consoleReturn.clear();
    }
    
    public void clear(){
    	turtleMap.clear();
    	commandHistory.clear();
    	clearConsoleReturn();
    	workspace.clear();
    }
    
    
}
