package model.commands.turtle;

import model.Position;
import model.TurtleState;
import model.abstractcommands.TurtleCommand;
import model.interfaces.TurtleCommandInterface;

public class Stamp extends TurtleCommand{

    public Stamp (double[] parameters, TurtleCommandInterface model) {
        super(parameters, model);
        // TODO Auto-generated constructor stub
    }

    @Override
    public double execute () throws Exception {
        System.out.println("Made it to the command!");
        TurtleState clonedTurtle = this.getModel().getTurtle().clone();
        System.out.println("Made it through the clone!");
        System.out.println("Cloned Turtle ID is" + clonedTurtle);
        this.getModel().getStamps().add(clonedTurtle);
        System.out.println("Made it through the adding of the clone");
        return clonedTurtle.getImageIndex();
    }

}
