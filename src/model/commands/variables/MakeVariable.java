package model.commands.variables;

import model.Model;
import model.commands.OneInputCommand;

public class MakeVariable extends OneInputCommand{

    private String name;
    
    public MakeVariable (String varName, double param1, Model model) {
        super(param1, model);
        name = varName;
    }

    @Override
    public double execute () {
        double value = getParam1();
        this.getModel().getWorkspace().addVariable(name, value);
        return value;
        
    }

    
}
