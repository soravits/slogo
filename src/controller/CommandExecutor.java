package controller;

import model.Model;

import java.lang.reflect.Constructor;

public class CommandExecutor implements Executor{

    public static final String COMMAND_PACKAGE = "model.commands.";

    @Override
    public double execute(Node root, CommandManager commandManager, CommandController commandController, Model model) throws Exception{
        if(commandManager.getControlStructures().contains(root.getValue())) {
            ControlExecutor controlExecutor = new ControlExecutor();
            return controlExecutor.execute(root,commandManager, commandController, model);
        }else if(commandManager.getUserInstructions().containsKey(root.getValue())){
            UserInstructionExecutor userInstructionExecutor = new UserInstructionExecutor();
            return userInstructionExecutor.execute(root,commandManager,commandController,model);
        }
        double[] doubles = new double[root.getChildren().size()];
        for (int i = 0; i < root.getChildren().size(); i++) {
            Node currNode = root.getChildren().get(i);
            doubles[i] = commandManager.executeNode(currNode);
        }
        Class<?> command = Class.forName(COMMAND_PACKAGE + root.getValue());
        Constructor<?> constructor = command.getDeclaredConstructor(double[].class, Model.class);
        Object t = constructor.newInstance(doubles, model);
        commandController.setCommand(t);
        double x = commandController.execute();
        model.updateConsoleReturn(x);
        return x;
    }
}
