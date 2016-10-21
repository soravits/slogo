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
}
