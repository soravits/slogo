package model.commands.general;

import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to return a random number between 0 and the input parameter
 * @author Brian
 *
 */
public class Random extends MathBoolCommand{

    public Random (double[] parameter, EmptyInterface model) {
        super(parameter, model);
    }

    @Override
    public double execute () {
        return  Math.random() * this.getParams()[0];
    }

}
