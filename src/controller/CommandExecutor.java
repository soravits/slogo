package controller;
import error.InvalidCommandException;
import model.Model;

/**
 * This class is responsible for executing commands based on their type.
 * @author Soravit Sophastienphong
 */

public class CommandExecutor extends Executor{

    /**
     * @param root The root of the expression tree of the command being executed.
     * @param commandManager A reference to a CommandManager object from which data can be obtained about command types.
     * @param model A reference to the current model.
     * @return The double returned by the execution of the root.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     */
    @Override
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