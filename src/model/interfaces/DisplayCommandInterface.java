package model.interfaces;

public interface DisplayCommandInterface {

    double getBackGround ();

    void setBackGround (double back);

    double getPenColor ();

    void setPenColor (double pencolor);

    double getPenSize ();

    void setPenSize (double pensize);

    double getPaletteIndex ();

    void setPaletteIndex (double paletteindex);

    double getShape ();

    void setShape (double shp);

    int[][] getPaletteColors ();

    void setPaletteColors (int index, int[] paletteColor);
}
