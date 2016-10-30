package controller;

import model.Model;

import java.lang.reflect.Constructor;

public class ControlExecutor implements Executor{

    @Override
    public double execute(Node root, CommandManager commandManager, CommandController commandController, Model model) throws Exception{
        Class<?> command = Class.forName(CommandExecutor.COMMAND_PACKAGE + root.getValue());
        Constructor<?> constructor = command.getDeclaredConstructor(Node.class, Interpreter.class, Model.class);
        Object t = constructor.newInstance(root, commandManager.getInterpreter(), model);
        commandController.setCommand(t);
        double x = commandController.execute();
        model.updateConsoleReturn(x);
        return x;
    }
}
