package view;

import java.util.LinkedList;
import java.util.Queue;

public class DataOut {
	private Queue<String> commandHistory;
	private Queue<String> consoleResults;
	
	DataOut() {
		this.commandHistory=new LinkedList<String>();
		this.consoleResults=new LinkedList<String>();
	}
	public void addCommandToHistory(String command) {
		commandHistory.add(command);
	}
	
	public Queue<String> getCommandHistory() {
		//for testing
		commandHistory.add("command 1");
		commandHistory.add("command 2");
		commandHistory.add("command 3");
		commandHistory.add("command 4");
		return commandHistory;
	}
	
	public void setConsoleResults(LinkedList<String> results) {
		//set consoleresults from the back
	}
	
	public Queue<String> getConsoleResults() {
		//for testing
		consoleResults.add("result 1");
		consoleResults.add("result 2");
		consoleResults.add("result 3");
		consoleResults.add("result 4");
		return consoleResults;
	}
	
	public void update() {
		//get updated data from controller
		//data needed for console
		//data needed for workspace
		//data needed for turtle
	}

}
