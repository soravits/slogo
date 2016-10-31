package model.commands;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Product extends MathBoolCommand{

    public Product (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        double product = 1;
        for (double x : this.getParams()){
            product *= x;
        }
        return product;
    }

}
