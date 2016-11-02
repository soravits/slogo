package controller;
import error.InvalidCommandException;
import model.Model;


public class CommandExecutor extends Executor{
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException{
        if(commandManager.getControlStructures().contains(root.getValue())) {
            ControlExecutor controlExecutor = new ControlExecutor();
            return controlExecutor.execute(root, commandManager, model);
        }
        else if (commandManager.getTurtleCommands().contains(root.getValue())){
            TurtleExecutor turtleExecutor = new TurtleExecutor();
            return turtleExecutor.execute(root, commandManager, model);
        }else if(commandManager.getDisplayCommands().contains(root.getValue())){
            DisplayExecutor displayExecutor = new DisplayExecutor();
            return displayExecutor.execute(root, commandManager, model);
        }
        else if(commandManager.getUserInstructions().containsKey(root.getValue())){
            UserInstructionExecutor userInstructionExecutor = new UserInstructionExecutor();
            return userInstructionExecutor.execute(root,commandManager,model);
        }else{
            return super.execute(root, commandManager, model);
        }
    }
}