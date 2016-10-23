
package model;

public class Position implements PositionInterface {
    
    private double xPosition;
    private double yPosition;
    
    
    public Position(){
        resetPosition();
    }
    /**
     * Construct a Position object of (x, y)
     * @param x
     * @param y
     */
    public Position(double x, double y){
        xPosition = x;
        yPosition = y;
    }
    
    @Override
    public void addX(double xAdd){
        xPosition = xPosition + xAdd;
    }
    
    @Override
    public void setX(double xUpdate){
        xPosition = xUpdate;
    }
    
    @Override
    public void addY(double yAdd){
        yPosition = yPosition + yAdd;
    }

    @Override
    public void setY(double yUpdate){
        yPosition = yUpdate;
    }
    
    @Override
    public double getX(){
        return xPosition;
    }
    
    @Override
    public double getY(){
        return yPosition;
    }
    
    @Override
    public void resetPosition(){
        xPosition = 0;
        yPosition = 0;
    }

}
