package controller;

import java.util.HashMap;
import java.util.Map;

public class ExecuteManager {
	
	public static final String COMMAND = "Command";
	public static final String VARIABLE = "Variable";
	public static final String CONSTANT = "Constant";


	private CommandParser syntax;
	private CommandParser commands;
	private Map<String, Executor> executions;
	
	public ExecuteManager(CommandParser syntax, CommandParser commands){
		this.syntax = syntax;
		this.commands = commands;
		executions = new HashMap<String, Executor>();
	}
	
	public void mapExecutions(){
		//executions.put(, arg1)
	}
	
	
	
}
