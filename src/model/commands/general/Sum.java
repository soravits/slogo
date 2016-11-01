package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Sum extends MathBoolCommand{
        
    public Sum (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        return sumParams();
    }
}
