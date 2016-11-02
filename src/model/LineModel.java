package model;

public class LineModel {

    Position position1;
    Position position2;
    
    public LineModel(Position pos1, Position pos2){
        position1 = pos1;
        position2 = pos2;
    }
    
    public double[][] getLine() {
        double[] point1 = {position1.getX(), position1.getY()};
        double[] point2 = {position2.getX(), position2.getY()};
        double[][] points = {point1, point2};
        return points;
    }
    
    public Position getPosition1(){
        return position1;
    }
    
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
