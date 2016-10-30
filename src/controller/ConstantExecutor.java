package controller;

import model.Model;
import model.commands.Constant;

public class ConstantExecutor implements Executor{

    @Override
    public double execute(Node root, CommandManager commandManager, CommandController controller, Model model) {
        double[] constantDouble = {Double.parseDouble(root.getValue())};
        Constant constant = new Constant(constantDouble, model);
        return constant.execute();
    }
}
