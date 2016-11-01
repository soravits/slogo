package model.commands.general;

import model.Model;
import model.abstractcommands.DisplayCommand;

public class SetPalette extends DisplayCommand{

    public SetPalette (double[] parameters, Model model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        double[] colors = {this.getParams()[1], this.getParams()[2], this.getParams()[3]};
        getModel().getDisplay().setPaletteColors(this.getParams()[0], colors);
        return this.getParams()[0];
    }

}