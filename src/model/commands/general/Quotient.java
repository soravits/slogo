package model.commands.general;

import error.InvalidCommandException;
import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Quotient extends MathBoolCommand {

    public Quotient (double[] parameters, Model model) {
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
