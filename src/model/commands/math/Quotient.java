package model.commands.math;

import model.Model;
import model.commands.TwoInputCommand;

public class Quotient extends TwoInputCommand {

    public Quotient (double parameter1, double parameter2, Model model) {
        super(parameter1, parameter2, model);
    }

    // NEED TO ADD DIVIDEBYZERO EXCEPTION;
    @Override
    public double execute () {
        return getParam1()/getParam2();
    }

}
