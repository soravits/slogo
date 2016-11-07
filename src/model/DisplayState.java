package model;

import model.interfaces.DisplayCommandInterface;

/**
 * Collection of different indices and values that are mapped to values utilized by the GUI display via
 * colors, pen size, shapes, etc. Getters and setters allow for easy manipulation of this data by Display Commands
 * @author Brian
 *
 */
public class DisplayState implements DisplayCommandInterface {
    
    private double backGround;
    private double penColor;
    private double penSize;
    private double shape;
    private double paletteIndex;
    private int[][] paletteColors;
    
    private final int MAX_NUMBER_OF_PALETTES = 20;
    private final int RGB_SIZE = 3;
    
    public DisplayState() {
        backGround = 1;
        penColor = 1;
        shape = 1;
        penSize = 1;
        paletteIndex = 1;
        paletteColors = new int[MAX_NUMBER_OF_PALETTES][RGB_SIZE];
    }

    @Override
    public double getBackGround () {
        return backGround;
    }

    @Override
    public void setBackGround (double back) {
        backGround = back;
    }

    @Override
    public double getPenColor () {
        return penColor;
    }

    @Override
    public void setPenColor (double pencolor) {
        penColor = pencolor;
    }

    @Override
    public double getPenSize () {
        return penSize;
    }

    @Override
    public void setPenSize (double pensize) {
        penSize = pensize;
    }

    @Override
    public double getPaletteIndex () {
        return paletteIndex;
    }

    @Override
    public void setPaletteIndex (double paletteindex) {
        paletteIndex = paletteindex;
    }

    @Override
    public double getShape () {
        return shape;
    }

    @Override
    public void setShape (double shp) {
        shape = shp;
    }

    @Override
    public int[][] getPaletteColors () {
        return paletteColors;
    }

    @Override
    public void setPaletteColors (int index, int[] paletteColor) {
        paletteColors[index] = paletteColor;
    }
    

}
