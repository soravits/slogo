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
        mapExecutions();
    }

    public double executeTree(Node root) throws InvalidCommandException {
        String s = syntax.getSymbol(root.getValue());
        return executions.get(s).execute(root, this, model);
    }
    public List<String> getControlStructures(){
        return controlStructures;
    }

    public Map<String, Node> getUserInstructions(){
        return userInstructions;
    }
    
    public List<String> getTurtleCommands(){
        return turtleCommands;
    }

    public double executeCommand(CommandInterface command) throws Exception {
        commandController.setCommand(command);
        return commandController.execute();
    }

    public void addInstruction(String commandName, Node root){
        userInstructions.put(commandName, root);
    }

    public boolean existsUserInstruction(String commandName){
        return userInstructions.containsKey(commandName);
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
