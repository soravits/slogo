package model.commands;

import model.Model;
import model.commandabstract.TwoInputCommand;

public class Product extends TwoInputCommand{

    public Product (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return getParam1()*getParam2();
    }

}
