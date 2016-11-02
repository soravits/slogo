package model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import model.interfaces.ControlCommandInterface;
import model.interfaces.DisplayCommandInterface;
import model.interfaces.EmptyInterface;
import model.interfaces.TurtleCommandInterface;
import model.interfaces.WorkspaceCommandInterface;
import view.data.ViewModelInterface;

public class Model extends Observable implements ControlCommandInterface, WorkspaceCommandInterface, EmptyInterface, DisplayCommandInterface, ViewModelInterface, TurtleCommandInterface{

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
    
    public double[][] getLines (double ID){
        return turtleMap.getLines(ID);
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

    public void updateConsoleReturn(Double value){
        //System.out.println("The value added to the console is " + value);
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
    
    public void changeActiveTurtle(double ID) {
        turtleController.changeTurtleActive(ID);
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

    public void updateView(){
        setChanged();
        notifyObservers();
        clearConsoleReturn();
    }

    @Override
    public double getBackGround () {
        return display.getBackGround();
    }

    @Override
    public void setBackGround (double back) {
        display.setBackGround(back);
    }

    @Override
    public double getPenColor () {
        return display.getPenColor();
    }

    @Override
    public void setPenColor (double pencolor) {
        display.setPenColor(pencolor);   
    }

    @Override
    public double getPenSize () {
        return display.getPenSize();
    }

    @Override
    public void setPenSize (double pensize) {
        display.setPenSize(pensize);
    }

    @Override
    public double getPaletteIndex () {
        return display.getPaletteIndex();
    }

    @Override
    public void setPaletteIndex (double paletteindex) {
        display.setPaletteIndex(paletteindex);
    }

    @Override
    public double getShape () {
        return display.getShape();
    }

    @Override
    public void setShape (double shp) {
        display.setShape(shp);
    }

    @Override
    public double[][] getPaletteColors () {
        return display.getPaletteColors();
    }

    @Override
    public void setPaletteColors (Double index, double[] paletteColor) {
        display.setPaletteColors(index, paletteColor);
    }

	@Override
	public DisplayState getDisplay() {
		// TODO Auto-generated method stub
		return null;
	}  
}
