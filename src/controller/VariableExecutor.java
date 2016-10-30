package controller;

import model.Model;
import model.commands.Variable;

public class VariableExecutor implements Executor{

    @Override
    public double execute(Node root, CommandManager commandManager, CommandController commandController, Model model) {
        Variable var = new Variable(root.getValue(), model);
        return var.execute();
    }
}
