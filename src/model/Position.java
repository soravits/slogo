
package model;

/**
 * Allows for packaging/manipulation of x and y coordinates together for a turtle's location in the GUI
 * @author Brian
 *
 */
public class Position implements Cloneable{
    
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
    private void resetPosition(){
        xPosition = 0;
        yPosition = 0;
    }
    
    /**
     * @param x
     * @param y
     * @return the distance between the current Position and a position specified by (x, y)
     */
    public double distance(double x, double y){
        return Math.sqrt(Math.pow(xPosition - x, 2) + Math.pow(yPosition - y, 2));
    }
    
    @Override
    public Position clone(){
        final Position clonedPosition = new Position(xPosition, yPosition);
        return clonedPosition;        
    }

}
