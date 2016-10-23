package model;

/**
* This class hold the basic information about the turtle model; used to update the state of the turtle after
* receiving a command, as well as get the individual characteristics of a turtle
* @author Brian
*
*/
public class TurtleState {

    private Position turtlePosition;
    private double turtleAngle;
    private boolean turtleShow;

    public TurtleState(){
        turtlePosition = new Position();
        turtleAngle = 0;
        turtleShow = true;
    }

    public TurtleState(Position position, double angle, boolean isShowing){
        turtlePosition = position;
        turtleAngle = angle;
        turtleShow = isShowing;
    }
    
    public Position getPosition(){
        return turtlePosition;
    }
    
    public void updateTurtlePosition (double x, double y){
        turtlePosition.addX(x);
        turtlePosition.addY(y);
    }

    public void setTurtlePosition (double x, double y){
        turtlePosition.setX(x);
        turtlePosition.setY(y);
    }    

    public void setTurtleAngle (double degrees) {
        turtleAngle = degrees;
    }

    public void addTurtleAngle (double degrees) {
        turtleAngle += degrees;
    }

    public void setShowTurtle (boolean setShow) {
        turtleShow = setShow;
    }

    public double getTurtleX () {
        return turtlePosition.getX();
    }

    public double getTurtleY () {
        return turtlePosition.getY();
    }

    public double getTurtleAngle () {
        return turtleAngle;
    }

    public boolean getShowTurtle () {
        return turtleShow;
    }
}
