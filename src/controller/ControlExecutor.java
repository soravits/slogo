package controller;

import java.lang.reflect.Constructor;
import error.InvalidCommandException;
import model.Model;
import model.abstractcommands.CommandInterface;
import model.interfaces.ControlCommandInterface;

public class ControlExecutor extends Executor{

    private static final String CONTROL_COMMAND_PACKAGE = "model.commands.control.";

    /**
     * @param root The root of the expression tree of the command being executed.
     * @param commandManager A reference to a CommandManager object from which data can be obtained about command types.
     * @param model A reference to the current model.
     * @return The double returned by the execution of the root.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     */
    @Override
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException{
        try {
            Class<?> command = Class.forName(CONTROL_COMMAND_PACKAGE + root.getValue());
            Constructor<?> constructor = command.getDeclaredConstructor(Node.class, CommandManager.class, ControlCommandInterface.class);
            Object t = constructor.newInstance(root, commandManager, model);
            double x = commandManager.executeCommand((CommandInterface) t);
            model.updateConsoleReturn(x);
            return x;
        }catch(Exception exception){
            exception.printStackTrace();
            throw new InvalidCommandException(root.getValue());
        }
    }
}
