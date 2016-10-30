package controller;

import error.InvalidCommandException;
import model.Model;
import model.commands.Constant;

public class ConstantExecutor implements Executor{

    @Override
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException {
        try {
            double[] constantDouble = {Double.parseDouble(root.getValue())};
            Constant constant = new Constant(constantDouble, model);
            return constant.execute();
        }catch(Exception e){
            throw new InvalidCommandException(root.getValue());
        }
    }
}
