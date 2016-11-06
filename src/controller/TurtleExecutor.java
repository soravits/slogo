package controller;

import error.InvalidCommandException;
import model.Model;
import model.interfaces.TurtleCommandInterface;

/**
 * This class is responsible for executing turtle commands.
 * @author Soravit Sophastienphong
 */

public class TurtleExecutor extends Executor{

    public static final String TURTLE_COMMAND_PACKAGE = "model.commands.turtle.";

    /**
     * @param root The root of the expression tree of the command being executed.
     * @param commandManager A reference to a CommandManager object from which data can be obtained about command types.
     * @param model A reference to the current model.
     * @return The double returned by the execution of the root.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     */
    @Override
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException {
        setPackage(TURTLE_COMMAND_PACKAGE);
        setCommandInterface(TurtleCommandInterface.class);
        double ret = 0;
        if(!root.getIsFoundTurtleCommand()) {
            setFoundTurtle(root);
            for(double d : model.getTurtlesToModify()){
                model.setTurtle(d);
                ret = super.execute(root, commandManager, model);
            }
        }else{
            ret = super.execute(root, commandManager, model);
        }
        return ret;
    }
    
    private void setFoundTurtle(Node root){
        if (root.getChildren() == null){
            return;
        }
        for (int i = 0; i < root.getChildren().size(); i++) {
            root.getChildren().get(i).setFoundTurtleCommand(true);
            setFoundTurtle(root.getChildren().get(i));
        }
    }
}
