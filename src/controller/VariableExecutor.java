package controller;

import error.InvalidCommandException;
import model.Model;
import model.commands.Variable;

public class VariableExecutor implements Executor{

    @Override
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException {
        try {
            Variable var = new Variable(root.getValue(), model);
            return var.execute();
        }catch(Exception e){
            throw new InvalidCommandException(root.getValue());
        }
    }
}
