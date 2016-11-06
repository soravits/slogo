package controller;

import error.InvalidCommandException;
import model.Model;
import model.commands.general.Variable;

/**
 * This class is responsible for dealing with the execution of variables in the expression tree.
 * @author Soravit Sophastienphong
 */

public class VariableExecutor extends Executor{

    /**
     * @param root The root of the expression tree of the command being executed.
     * @param commandManager A reference to a CommandManager object from which data can be obtained about command types.
     * @param model A reference to the current model.
     * @return The double returned by the execution of the root.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     */
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
