package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Product extends MathBoolCommand{

    public Product (double[] parameters, EmptyInterface model) {
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
