package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import error.InvalidCommandException;
import model.Model;
import model.abstractcommands.CommandInterface;

/**
 * This class is responsible for managing the execution of commands based on their type.
 * @author Soravit Sophastienphong
 */

public class CommandManager {

    public static final String COMMAND = "Command";
    public static final String VARIABLE = "Variable";
    public static final String CONSTANT = "Constant";

    private CommandParser syntax;
    private CommandController commandController;
    private Model model;
    private Map<String, Executor> executions;
    private CommandExecutor commandExecutor;
    private VariableExecutor variableExecutor;
    private ConstantExecutor constantExecutor;
    private Map<String, Node> userInstructions;
    private List<String> controlStructures;
    private List<String> turtleCommands;
    private List<String> displayCommands;

    /***
     *
     * @param syntax A reference to the CommandParser object containing the patterns representing the syntax of different types of commands.
     * @param commandController A reference to the CommandController object keeping track of the commands that have been run.
     * @param model A reference to the current model.
     */
    public CommandManager(CommandParser syntax, CommandController commandController, Model model){
        this.syntax = syntax;
        this.commandController = commandController;
        this.model = model;
        executions = new HashMap<String, Executor>();
        userInstructions = new HashMap<String, Node>();
        commandExecutor = new CommandExecutor();
        variableExecutor = new VariableExecutor();
        constantExecutor = new ConstantExecutor();
        controlStructures = processCommandType(Interpreter.RESOURCE_PACKAGE + File.separator + Interpreter.CONTROL_STRUCTURES);
        turtleCommands = processCommandType(Interpreter.RESOURCE_PACKAGE + File.separator + Interpreter.TURTLE_COMMANDS);
        displayCommands = processCommandType(Interpreter.RESOURCE_PACKAGE + File.separator + Interpreter.DISPLAY_COMMANDS);
        mapExecutions();
    }

    /**
     * Executes the command represented by the expression tree rooted at the passed node.
     * @param root The root of the expression tree of the command to be executed.
     * @return The double returned by the command rooted at root.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     */
    public double executeTree(Node root) throws InvalidCommandException {
        String s = syntax.getSymbol(root.getValue());
        return executions.get(s).execute(root, this, model);
    }

    /**
     * @return The list of control commands.
     */
    public List<String> getControlStructures(){
        return controlStructures;
    }

    /**
     * @return The current list of instructions defined by the user.
     */
    public Map<String, Node> getUserInstructions(){
        return userInstructions;
    }

    /**
     * @return The list of turtle commands.
     */
    public List<String> getTurtleCommands(){
        return turtleCommands;
    }

    /**
     * @return The list of display commands.
     */
    public List<String> getDisplayCommands(){
        return displayCommands;
    }

    /**
     * Add the expression tree representing the user instruction to the current list of user instruction.
     * @param commandName The name of the command to be added.
     * @param root The root of the expression tree.
     */
    public void addInstruction(String commandName, Node root){
        userInstructions.put(commandName, root);
    }

    /**
     * @param commandName The name of the instruction.
     * @return Whether the user instruction has been defined.
     */
    public boolean existsUserInstruction(String commandName){
        return userInstructions.containsKey(commandName);
    }

    /**
     * @param command A command interface object representing the command to be executed.
     * @return The double returned by the executed command.
     * @throws Exception If an error exists that is related to the command's execution.
     */
    public double executeCommand(CommandInterface command) throws Exception {
        commandController.setCommand(command);
        return commandController.executeCommand();
    }

    private void mapExecutions(){
        executions.put(COMMAND, commandExecutor);
        executions.put(VARIABLE, variableExecutor);
        executions.put(CONSTANT, constantExecutor);
    }

    private List<String> processCommandType(String syntax) {
        ArrayList<String> controlStructures = new ArrayList<String>();
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            controlStructures.add(iter.nextElement());
        }
        return controlStructures;
    }
    
}
