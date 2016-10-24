package model.commands.math;

import model.Model;
import model.commands.TwoInputCommand;

public class Quotient extends TwoInputCommand {

    public Quotient (double[] parameters, Model model) {
        super(parameters, model);
    }

    // NEED TO ADD DIVIDEBYZERO EXCEPTION;
    @Override
    public double execute () {
        return getParam1()/getParam2();
    }

}
