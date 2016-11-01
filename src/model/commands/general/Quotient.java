package model.commands.general;

import error.InvalidCommandException;
import model.abstractcommands.MathBoolCommand;
import model.interfaces.EmptyInterface;

public class Quotient extends MathBoolCommand {

    public Quotient (double[] parameters, EmptyInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws InvalidCommandException {
        if (this.getParams()[1] == 0){
            throw new InvalidCommandException("Divide By Zero");
        }
        else{
            double div = this.getParams()[0];
            for (int i = 1; i < this.getParams().length; i++){
                div /= this.getParams()[i];
            }
            return div;
        }
    }

}
