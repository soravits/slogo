package controller;

import error.InvalidCommandException;

import model.Model;
import model.abstractcommands.Command;
import model.abstractcommands.CommandInterface;
import java.lang.reflect.Constructor;

public class CommandExecutor implements Executor{

//    public static final String COMMAND_PACKAGE = "model.commands.";
//    public static final String CONTROL_COMMAND_PACKAGE = "model.controlcommands.";

    @Override
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException{
        if(commandManager.getControlStructures().contains(root.getValue())) {
            ControlExecutor controlExecutor = new ControlExecutor();
            return controlExecutor.execute(root, commandManager, model);
        }
        else if (commandManager.getTurtleCommands().contains(root.getValue())){
            // Add TurtleCommand Executor Right Here
        }
        else if(commandManager.getUserInstructions().containsKey(root.getValue())){
            UserInstructionExecutor userInstructionExecutor = new UserInstructionExecutor();
            return userInstructionExecutor.execute(root,commandManager,model);
        }
        try{
        double[] doubles = new double[root.getChildren().size()];
        for (int i = 0; i < root.getChildren().size(); i++) {
            Node currNode = root.getChildren().get(i);
            doubles[i] = commandManager.executeTree(currNode);
        }
        Class<?> command = Class.forName(COMMAND_PACKAGE + root.getValue());
        Constructor<?> constructor = command.getDeclaredConstructor(double[].class, Model.class);
        Object t = constructor.newInstance(doubles, model);
        double x = commandManager.executeCommand((CommandInterface) t);
        model.updateConsoleReturn(x);
        return x;
        }catch(Exception exception){
            throw new InvalidCommandException(root.getValue());
        }
    }
}
