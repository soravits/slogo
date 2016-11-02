package model;

import model.interfaces.DisplayCommandInterface;

public class DisplayState implements DisplayCommandInterface {
    
    private double backGround;
    private double penColor;
    private double penSize;
    private double shape;
    private double paletteIndex;
    private double[][] paletteColors;
    
    public DisplayState() {
        backGround = 1;
        penColor = 1;
        shape = 1;
        penSize = 1;
        paletteIndex = 1;
        paletteColors = new double[20][3];
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#getBackGround()
     */
    @Override
    public double getBackGround () {
        return backGround;
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#setBackGround(double)
     */
    @Override
    public void setBackGround (double back) {
        backGround = back;
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#getPenColor()
     */
    @Override
    public double getPenColor () {
        return penColor;
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#setPenColor(double)
     */
    @Override
    public void setPenColor (double pencolor) {
        penColor = pencolor;
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#getPenSize()
     */
    @Override
    public double getPenSize () {
        return penSize;
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#setPenSize(double)
     */
    @Override
    public void setPenSize (double pensize) {
        penSize = pensize;
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#getPaletteIndex()
     */
    @Override
    public double getPaletteIndex () {
        return paletteIndex;
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#setPaletteIndex(double)
     */
    @Override
    public void setPaletteIndex (double paletteindex) {
        paletteIndex = paletteindex;
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#getShape()
     */
    @Override
    public double getShape () {
        return shape;
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#setShape(double)
     */
    @Override
    public void setShape (double shp) {
        shape = shp;
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#getPaletteColors()
     */
    @Override
    public double[][] getPaletteColors () {
        return paletteColors;
    }

    /* (non-Javadoc)
     * @see model.DisplayCommandInterface#setPaletteColors(java.lang.Double, double[])
     */
    @Override
    public void setPaletteColors (Double index, double[] paletteColor) {
        paletteColors[index.intValue()] = paletteColor;
    }
    

}
