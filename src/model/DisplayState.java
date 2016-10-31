package model;

public class DisplayState {
    
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

    public double getBackGround () {
        return backGround;
    }

    public void setBackGround (double back) {
        backGround = back;
    }

    public double getPenColor () {
        return penColor;
    }

    public void setPenColor (double pencolor) {
        penColor = pencolor;
    }

    public double getPenSize () {
        return penSize;
    }

    public void setPenSize (double pensize) {
        penSize = pensize;
    }

    public double getPaletteIndex () {
        return paletteIndex;
    }

    public void setPaletteIndex (double paletteindex) {
        paletteIndex = paletteindex;
    }

    public double getShape () {
        return shape;
    }

    public void setShape (double shp) {
        shape = shp;
    }

    public double[][] getPaletteColors () {
        return paletteColors;
    }

    public void setPaletteColors (Double index, double[] paletteColor) {
        paletteColors[index.intValue()] = paletteColor;
    }
    

}
