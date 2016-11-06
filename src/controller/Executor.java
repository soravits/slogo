package controller;

import error.InvalidCommandException;
import model.Model;
import model.abstractcommands.CommandInterface;
import model.interfaces.EmptyInterface;
import model.interfaces.TurtleCommandInterface;

import java.lang.reflect.Constructor;

/**
 * This is a superclass representing a general command executor, which contains a method for executing a command that
 * takes doubles as parameter(s) with reflection. It can be extended to define the behavior of specific types of
 * commands.
 * @author Soravit Sophastienphong
 */
public abstract class Executor {

    private static final String GENERAL_COMMAND_PACKAGE = "model.commands.general.";
    private String commandPackage = GENERAL_COMMAND_PACKAGE;
    private Class commandInterface = EmptyInterface.class;

    /**
     * @param root The root of the expression tree of the command being executed.
     * @param commandManager A reference to a CommandManager object from which data can be obtained about command types.
     * @param model A reference to the current model.
     * @return The double returned by the execution of the root.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     */
    public double execute(Node root, CommandManager commandManager, Model model) throws InvalidCommandException{
        try{
            Node paramRoot = root;
            if(root.getChildren().size() > 0 && root.getChildren().get(0).getValue().equals(Interpreter.CONTROL_STRUCTURES)){
                paramRoot = root.getChildren().get(0);
            }
            double[] doubles = new double[paramRoot.getChildren().size()];
            for (int i = 0; i < paramRoot.getChildren().size(); i++) {
                Node currNode = paramRoot.getChildren().get(i);
                doubles[i] = commandManager.executeTree(currNode);
            }
            Class<?> command = Class.forName(commandPackage + root.getValue());
            Constructor<?> constructor = command.getDeclaredConstructor(double[].class, commandInterface);
            Object t = constructor.newInstance(doubles, model);
            double x = commandManager.executeCommand((CommandInterface) t);
            model.updateConsoleReturn(x);
            model.updateView();
            return x;
        }catch(Exception exception){
            throw new InvalidCommandException(root.getValue());
        }
    }

    /**
     * Sets the package containing the classes of the commands being executed.
     * @param commandPackage The path to the package.
     */
    public void setPackage(String commandPackage){
        this.commandPackage = commandPackage;
    }

    /**
     * @return The path to the current package.
     */
    public String getPackage(){
        return commandPackage;
    }

    /**
     * Sets the interface containing the methods that the commands need to run properly.
     * @param commandInterface The class object of that interface.
     */
    public void setCommandInterface(Class commandInterface){
        this.commandInterface = commandInterface;
    }
}
