package model.commands;

import model.Model;
import model.commandabstract.Command;

public class Pi extends Command{

    public Pi (double[] parameters, Model model) {
        super(model);
    }

    @Override
    public double execute () {
        return Math.PI;
    }

}