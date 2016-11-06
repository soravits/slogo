package controller;

import error.InvalidCommandException;
import model.Model;
import model.commands.general.Constant;

/**
 * This class is responsible for dealing with the execution of constants in an expression tree.
 * @author Soravit Sophastienphong
 */

public class ConstantExecutor extends Executor{

    /**
     * @param root The node containing the constant.
     * @param commandManager A reference to a CommandManager object from which data can be obtained about command types.
     * @param model A reference to the current model.
     * @return The constant as a double.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     */
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
