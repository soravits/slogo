package controller;

import model.Model;

import java.io.File;
import java.util.*;

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
    private Interpreter interpreter;

    public CommandManager(Interpreter interpreter, CommandParser syntax, CommandController commandController, Model model){
		this.interpreter = interpreter;
        this.syntax = syntax;
        this.commandController = commandController;
        this.model = model;
		executions = new HashMap<String, Executor>();
        userInstructions = new HashMap<String, Node>();
        commandExecutor = new CommandExecutor();
        variableExecutor = new VariableExecutor();
        constantExecutor = new ConstantExecutor();
        controlStructures = processControlStructures(Interpreter.RESOURCE_PACKAGE + File.separator + Interpreter.CONTROL_STRUCTURES);
        mapExecutions();
    }
	
	public void mapExecutions(){
		executions.put(COMMAND, commandExecutor);
        executions.put(VARIABLE, variableExecutor);
        executions.put(CONSTANT, constantExecutor);
    }

    public double executeNode(Node root) throws Exception {
        String s = syntax.getSymbol(root.getValue());
        return executions.get(s).execute(root, this, commandController, model);
    }

    private ArrayList<String> processControlStructures(String syntax) {
        ArrayList<String> controlStructures = new ArrayList<String>();
        ResourceBundle resources = ResourceBundle.getBundle(syntax);
        Enumeration<String> iter = resources.getKeys();
        while (iter.hasMoreElements()) {
            controlStructures.add(iter.nextElement());
        }
        return controlStructures;
    }

    public List<String> getControlStructures(){
        return controlStructures;
    }

    public Map<String, Node> getUserInstructions(){
        return userInstructions;
    }

    public Interpreter getInterpreter(){
        return interpreter;
    }
}
