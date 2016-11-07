package model.commands.display;

import model.abstractcommands.DisplayCommand;
import model.interfaces.DisplayCommandInterface;

/**
 * Command to set the palette index to the specified index
 * @author Brian
 *
 */
public class SetPalette extends DisplayCommand{

    public SetPalette (double[] parameters, DisplayCommandInterface model) {
        super(parameters, model);
    }

    @Override
    public double execute () throws Exception {
        int[] colors = {(int) this.getParams()[1], (int) this.getParams()[2], (int) this.getParams()[3]};
        this.getModel().setPaletteColors((int) this.getParams()[0], colors);
        return this.getParams()[0];
    }

}
