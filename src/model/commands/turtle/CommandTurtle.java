package model.commands.turtle;

import model.Model;
import model.commands.Command;

public abstract class CommandTurtle extends Command{

    public CommandTurtle (double[] params, Model model) {
        super(params, model);
    }
    
    public double normalizeAngle(double angle){
        double normalizedAngle = angle % 360;
        if (normalizedAngle < 0){
            normalizedAngle += 360;
        }
        return normalizedAngle;
    }

}
