package model;

public class TurtleState implements TurtleStateInterface{

    private PositionInterface turtlePosition;
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


    @Override
    public void setTurtleX (double x) {
        turtlePosition.setX(x);
    }

    @Override
    public void addTurtleX (double x) {
        turtlePosition.addX(x);
    }

    @Override
    public void setTurtleY (double y) {
        turtlePosition.setY(y);
    }

    @Override
    public void addTurtleY (double y) {
        turtlePosition.addY(y);
    }

    @Override
    public void setTurtleAngle (double degrees) {
        turtleAngle = degrees;
    }

    @Override
    public void addTurtleAngle (double degrees) {
        turtleAngle += degrees;
    }

    @Override
    public void setShowTurtle (boolean setShow) {
        turtleShow = setShow;
    }

    @Override
    public double getTurtleX () {
        return turtlePosition.getX();
    }

    @Override
    public double getTurtleY () {
        return turtlePosition.getY();
    }

    @Override
    public double getTurtleAngle () {
        return turtleAngle;
    }

    @Override
    public boolean getShowTurtle () {
        return turtleShow;
    }

}
