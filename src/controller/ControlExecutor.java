package controller;

import java.lang.reflect.Constructor;
import error.InvalidCommandException;
import model.Model;
import model.abstractcommands.CommandInterface;
import model.interfaces.ControlCommandInterface;

public class ControlExecutor extends Executor{

    public static final String CONTROL_COMMAND_PACKAGE = "model.commands.control.";

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
