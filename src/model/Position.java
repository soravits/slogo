
package model;

public class Position {
    
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
    
    /**
     * Add to current value of x position
     * @param xAdd
     */
    public void addX(double xAdd){
        xPosition = xPosition + xAdd;
    }
    
    /**
     * Add to current value of y position
     * @param xUpdate
     */
    public void setX(double xUpdate){
        xPosition = xUpdate;
    }
    
    /**
     * Add to current value of y position
     * @param yAdd
     */
    public void addY(double yAdd){
        yPosition = yPosition + yAdd;
    }

    /**
     * Overwrite current value of y position with new value
     * @param yUpdate
     */
    public void setY(double yUpdate){
        yPosition = yUpdate;
    }
    
    /**
     * @return current X value of the position
     */
    public double getX(){
        return xPosition;
    }
    
    /**
     * @return current Y value of the position
     */
    public double getY(){
        return yPosition;
    }
    
    /**
     * Reset position to 0, 0
     * Called in constructor with no input arguments, can also be called by other classes
     */
    public void resetPosition(){
        xPosition = 0;
        yPosition = 0;
    }

}
