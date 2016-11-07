package model.interfaces;

/**
 * Interface used by the Display Commands to manipulate the status of the model after changes submitted
 * via either the front-end GUI or via typed commands
 * @author Brian
 *
 */
public interface DisplayCommandInterface {

    /**
     * @return current background color index
     */
    double getBackGround ();

    /**
     * Set the current background color to the specified index
     * @param back : index of background color
     */
    void setBackGround (double back);

    /**
     * @return index of current pen color in GUI
     */
    double getPenColor ();

    /**
     * Set the current pen color to the specified index
     * @param pencolor : index of pen color
     */
    void setPenColor (double pencolor);

    /**
     * @return current size of the pen in pixels
     */
    double getPenSize ();

    /**
     * Set the size of the pen to the specified pixel size
     * @param pensize : width of pen in pixels
     */
    void setPenSize (double pensize);

    /**
     * @return current palette
     */
    double getPaletteIndex ();

    /**
     * Set the palette's number to the specified index
     * @param paletteindex : new index for the palette
     */
    void setPaletteIndex (double paletteindex);

    /**
     * @return index of the shape (in our case it was image) of the turtles from the GUI
     */
    double getShape ();

    /**
     * Change the shape of the turtles in the GUI to that specified by the index
     * @param shp : index of the new shape
     */
    void setShape (double shp);

    /**
     * @return array of palette color indices and their corresponding array of r g b values
     */
    int[][] getPaletteColors ();

    /**
     * Set a new palette with index index to have the following array of r g b colors
     * @param index : index of the changing palette
     * @param paletteColor : r g b composition of the new palette
     */
    void setPaletteColors (int index, int[] paletteColor);
}
