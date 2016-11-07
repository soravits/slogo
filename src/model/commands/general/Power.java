package model.commands.general;
import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

/**
 * Command to return the first input raised to the power of the second input, which is then raised
 * to the power of the third input (if applicable), which is then....
 * @author Brian
 *
 */
public class Power extends MathBoolCommand{

    public Power (double[] parameters, EmptyInterface model) {
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
