package model;
import java.util.ArrayList;
import java.util.Collection;

import model.interfaces.*;
import view.data.ViewModelInterface;

public class Model implements ControlCommandInterface, WorkspaceCommandInterface, EmptyInterface, DisplayCommandInterface, ViewModelInterface, TurtleCommandInterface{

    private TurtleController turtleController;
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
        turtleController = new TurtleController();
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

    public TurtleState getTurtle (double ID){
        return turtleMap.getTurtle(ID);
    }
    
    public double getID () {
        return turtleMap.getCurrentID();
    }
    
    public Collection<Double> getIDs(){
    	return turtleMap.getIDs();
    }
    
    public boolean getShowTurtle(double id){
    	return turtleMap.getTurtle(id).getShowTurtle();
    }
    
    public double getTurtleAngle(double id){
    	return turtleMap.getTurtle(id).getTurtleAngle();
    }
    
    public double getTurtleX(double id){
    	return turtleMap.getTurtle(id).getTurtleX();
    }
    
    public double getTurtleY(double id){
    	return turtleMap.getTurtle(id).getTurtleY();
    }
    
    public boolean isPenDown(double id){
    	return turtleMap.getLineState(id).isPenDown();
    }
    
    public void setTurtle (double ID){
        turtleMap.setCurrentID(ID);
    }
    
    @Override
    public LineState getLineState () {
        return turtleMap.getLineState();
    }
    
    public LineState getLineState (double ID){
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
    
    
    
    public void updateID (double ID){

        turtleMap.setCurrentID(ID);
    }

    @Override
    public void addTurtle (double ID) {
        turtleMap.addTurtle(ID);
        turtleController.addTurtle(ID);
    }

    @Override
    public void removeTellTurtle (double ID) {
        turtleController.removeTellTurtle(ID);
    }

    @Override
    public void clearTellTurtles () {
        turtleController.clearTellTurtles();
    }


    @Override
    public Collection<Double> getTurtlesToModify () {
        return turtleController.getTurtlesToModify();
    }

    @Override
    public void addNestedAsk () {
        turtleController.addNestedAsk();
    }

    @Override
    public void subtractNestedAsk () {
        turtleController.subtractNestedAsk();
    }

    public boolean isTell() {
        return turtleController.isTell();
    }

    public void setTell(boolean tell) {
        turtleController.setTell(tell);
    }

    @Override
    public void clearAskTurtles() {
        turtleController.clearAskTurtles();
    }

}
