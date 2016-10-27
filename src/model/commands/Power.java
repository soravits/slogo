package model.commands;
import model.Model;
import model.abstractcommands.TwoInputCommand;

public class Power extends TwoInputCommand{

    public Power (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute ()  {
        return Math.pow(getParam1(), getParam2());
    }

}
