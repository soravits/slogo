package model.commands;

import model.Model;
import model.Position;
import model.commandabstract.Command;

public class Home extends Command{

    public Home (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () throws Exception {
        return moveToZero();
    }
    
    public double moveToZero(){
        Position pos1 = getModel().getTurtle().getPosition().clone();
        double distance = pos1.distance(0, 0);
        getModel().getTurtle().setTurtlePosition(0, 0);
        return distance;
    }
}
