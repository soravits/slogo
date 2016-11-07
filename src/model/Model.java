package model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import model.interfaces.ControlCommandInterface;
import model.interfaces.DisplayCommandInterface;
import model.interfaces.EmptyInterface;
import model.interfaces.TurtleCommandInterface;
import view.data.ViewModelInterface;

/**
 * Observable collection of the different components of the back-end datat stored for use by both the 
 * Front-End and the controller. Multiple interfaces implemented in order to hide implementation from
 * classes that do not need access to the full model. Contains an instance of:
 *      TurtleController, TurtleMap, DisplayState, WorkspaceState, and collections of the commands
 *      called and the console return outputs to be printed
 * @author Brian
 *
 */
public class Model extends Observable implements ControlCommandInterface, EmptyInterface, DisplayCommandInterface, ViewModelInterface, TurtleCommandInterface{

    private TurtleController turtleController;
    private DisplayState display;
    private TurtleMap turtleMap;
    private WorkspaceState workspace;
    private Collection<String> commandHistory;
    private Collection<String> consoleReturn;

    public Model(){
        this.display = new DisplayState();
        this.turtleMap = new TurtleMap();
        this.workspace = new WorkspaceState();
        this.commandHistory = new ArrayList<String>();
        this.consoleReturn = new ArrayList<String>();
        this.turtleController = new TurtleController();
    }

    @Override
    public TurtleMap getTurtleMap (){
        return turtleMap;
    }

    @Override
    public double getNumberOfTurtles (){
        return turtleMap.getIDs().size();
    }

    @Override
    public TurtleState getTurtle () {
        return turtleMap.getTurtle();
    }
    
    @Override
    public double getID () {
        return turtleMap.getCurrentID();
    }

    @Override
    public Collection<Double> getIDs(){
        return turtleMap.getIDs();
    }

    @Override
    public boolean getShowTurtle(double id){
        return turtleMap.getTurtle(id).getShowTurtle();
    }

    @Override
    public double getTurtleAngle(double id){
        return turtleMap.getTurtle(id).getTurtleAngle();
    }

    @Override
    public double getTurtleX(double id){
        return turtleMap.getTurtle(id).getTurtleX();
    }

    @Override
    public double getTurtleY(double id){
        return turtleMap.getTurtle(id).getTurtleY();
    }

    @Override
    public boolean isPenDown(double id){
        return turtleMap.getLineState(id).isPenDown();
    }


    /**
     * Set the current ID of the Turtle Map to the input ID
     * @param ID is ID of the current turtle being actively changed in the map
     */
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

    @Override
    public double[][] getLines (double ID){
        return turtleMap.getLines(ID);
    }

    @Override
    public WorkspaceState getWorkspace () {
        return workspace;
    }

    @Override
    public Collection<String> getCommandHistory() {
        return commandHistory;
    }

    /**
     * Add a command to the model's command history
     * @param command : String detailing the command that has been passed to the parser
     */
    public void addCommand(String command){
        commandHistory.add(command);
    }

    @Override
    public Collection<String> getConsoleReturn(){
        return consoleReturn;
    }

    /**
     * Add a new return value to the collection of values to be returned
     * @param value
     */
    public void updateConsoleReturn(Double value){
        consoleReturn.add(value.toString());
    }

    /**
     * clear all of the data from the model and start back in an initialized state
     */
    public void clear(){
        turtleMap.clear();
        commandHistory.clear();
        clearConsoleReturn();
        workspace.clear();
    }

    @Override
    public void changeActiveTurtle(double ID) {
        turtleController.changeActiveTurtle(ID);
    }

    @Override
    public void addTurtle (double ID) {
        turtleMap.addTurtle(ID);
        turtleController.addTurtle(ID);
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

    /**
     * Notifies the controller that the model has been changed; cleans out the console return
     */
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
    public int[][] getPaletteColors () {
        return display.getPaletteColors();
    }

    @Override
    public void setPaletteColors (int index, int[] paletteColor) {
        display.setPaletteColors(index, paletteColor);
    }

    @Override
    public DisplayState getDisplay() {
        return display;
    }  
    

    private void clearConsoleReturn(){
        consoleReturn.clear();
    }


}
