package model.commands.general;

import model.Model;
import model.abstractcommands.MathBoolCommand;

public class Equal extends MathBoolCommand {

    public Equal (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () {
        double first = this.getParams()[0];
        for (double x : this.getParams()){
            if (x != first){
                return 0;
            }
        }
        return 1;
    }
}
