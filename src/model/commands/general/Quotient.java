package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Quotient extends MathBoolCommand {

    public Quotient (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        double div = this.getParams()[0];
        for (int i = 1; i < this.getParams().length; i++){
            div /= this.getParams()[i];
        }
        return div;
    }

}
