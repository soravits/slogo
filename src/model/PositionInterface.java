package model;

public interface PositionInterface {

    /**
     * Add to current value of x position
     * @param xAdd
     */
    void addX (double xAdd);

    /**
     * Add to current value of y position
     * @param xUpdate
     */
    void setX (double xUpdate);

    /**
     * Add to current value of y position
     * @param yAdd
     */
    void addY (double yAdd);

    /**
     * Overwrite current value of y position with new value
     * @param yUpdate
     */
    void setY (double yUpdate);

    /**
     * @return current X value of the position
     */
    double getX ();

    /**
     * @return current Y value of the position
     */
    double getY ();

    /**
     * Reset position to 0, 0
     * Called in constructor with no input arguments, can also be called by other classes
     */
    void resetPosition ();

}
