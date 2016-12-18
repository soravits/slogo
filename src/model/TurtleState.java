package model;

/**
* This class hold the basic information about the turtle model; used to update the state of the turtle after
* receiving a command, as well as get the individual characteristics of a turtle
* @author Brian
*
*/
public class TurtleState implements Cloneable{

    private int turtleImageIndex;
    private Position turtlePosition;
    private double turtleAngle;
    private boolean turtleShow;

    public TurtleState(){
        this.turtlePosition = new Position();
        this.turtleAngle = 0;
        this.turtleShow = true;
        this.turtleImageIndex = 1;
    }

    public TurtleState(Position position, double angle, boolean isShowing, int imageIndex){
        this.turtlePosition = position;
        this.turtleAngle = angle;
        this.turtleShow = isShowing;
        this.turtleImageIndex = imageIndex;
    }
    
    /**
     * 
     * @return current Position of the turtle
     */
    public Position getPosition(){
        return turtlePosition;
    }
    
    /**
     * Update current turtle position to move forward by x in the x-direction and y in the y-direction
     * @param x
     * @param y
     */
    public void updateTurtlePosition (double x, double y){
        turtlePosition.addX(x);
        turtlePosition.addY(y);
    }

    /**
     * Set current turtle position to (x, y)
     * @param x
     * @param y
     */
    public void setTurtlePosition (double x, double y){
        turtlePosition.setX(x);
        turtlePosition.setY(y);
    }    

    /**
     * Set current turtle's heading angle to degrees
     * @param degrees
     */
    public void setTurtleAngle (double degrees) {
        turtleAngle = degrees;
    }

    /**
     * Add a number of degrees to the turtle's current heading
     * @param degrees
     */
    public void addTurtleAngle (double degrees) {
        turtleAngle += degrees;
    }

    /**
     * set whether or not to display the turtle in the GUI
     * @param setShow
     */
    public void setShowTurtle (boolean setShow) {
        turtleShow = setShow;
    }

    /**
     * @return the turtle's current X position
     */
    public double getTurtleX () {
        return turtlePosition.getX();
    }
    
    /** 
     * @return current Y-coordinate of the turtle
     */
    public double getTurtleY () {
        return turtlePosition.getY();
    }

    /**
     * get the current angle of the turtle
     * @return
     */
    public double getTurtleAngle () {
        return turtleAngle;
    }

    /**
     * @return whether or not the turtle is currently showing
     */
    public boolean getShowTurtle () {
        return turtleShow;
    }
    
    public int getImageIndex(){
        return turtleImageIndex;
    }
    
    public void setImageIndex(int index){
        this.turtleImageIndex = index;
    }
    
    @Override
    public TurtleState clone(){
        final TurtleState clonedTurtle = new TurtleState(turtlePosition, turtleAngle, turtleShow, turtleImageIndex);
        return clonedTurtle;        
    }
}
