package model.commands;
import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Power extends MathBoolCommand{

    public Power (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute ()  {
        double first = this.getParams()[0];
        for (int i = 1; i < this.getParams().length; i++){
            first = Math.pow(first, this.getParams()[i]);
        }
        return first;
    }

}
