package model;

/**
 * Packages together 2 positions as a line. Collection of these are stored in LineState for each Turtle
 * in order to be able to retrace the full path of the turtle if necessary
 * @author Brian
 *
 */
public class LineModel {

    Position position1;
    Position position2;
    
    public LineModel(Position pos1, Position pos2){
        position1 = pos1;
        position2 = pos2;
    }
    
    /**
     * @return an array of points split into 2 doubles (allows Front End to process position much more easily)
     */
    public double[][] getLine() {
        double[] point1 = {position1.getX(), position1.getY()};
        double[] point2 = {position2.getX(), position2.getY()};
        double[][] points = {point1, point2};
        return points;
    }
    
    /**
     * 
     * @return First Position in the line
     */
    public Position getPosition1(){
        return position1;
    }
    
    /**
     * 
     * @return Second Position in the line
     */
    public Position getPosition2(){
        return position2;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj == null | obj.getClass() != getClass()){
            return false;
        }
        LineModel other = (LineModel) obj;
        return ((this == obj) |  
                (other.getPosition1().equals(position1) & other.getPosition2().equals(position2)));    
    }
    
    @Override
    public String toString(){
        return position1.toString() +  " " + position2.toString();
    }
}
