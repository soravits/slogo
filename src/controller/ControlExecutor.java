package controller;

import error.InvalidCommandException;
import model.Model;
import model.abstractcommands.Command;
import model.abstractcommands.CommandInterface;
import java.lang.reflect.Constructor;

public class ControlExecutor extends Executor{

    public static final String CONTROL_COMMAND_PACKAGE = "model.commands.control.";

    @Override
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException{
        try {
            Class<?> command = Class.forName(CONTROL_COMMAND_PACKAGE + root.getValue());
            Constructor<?> constructor = command.getDeclaredConstructor(Node.class, CommandManager.class, Model.class);
            Object t = constructor.newInstance(root, commandManager, model);
            double x = commandManager.executeCommand((CommandInterface) t);
            model.updateConsoleReturn(x);
            return x;
        }catch(Exception exception){
            throw new InvalidCommandException(root.getValue());
        }
    }
}
