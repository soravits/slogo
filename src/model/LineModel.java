package model;

public class LineModel {

    Position position1;
    Position position2;
    
    public LineModel(Position pos1, Position pos2){
        position1 = pos1;
        position2 = pos2;
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
}
