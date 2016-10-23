package view.data;

/**
 *View External API is mainly responsible of receiving data from the backend to be displayed on UI. 
 * @author Pim
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import model.Model;

public class DataOut {
	private Queue<String> commandHistory;
	private Queue<String> consoleResults;
	private HashMap<String,Double> variableMap;
	
	public DataOut() {
		this.commandHistory=new LinkedList<String>();
		this.consoleResults=new LinkedList<String>();
		this.variableMap=new HashMap<String,Double>();
	}
	public void setCommandToHistory(String command) {
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
	
	public void setConsoleResults(Queue<String> results) {
		this.consoleResults=results;
	}
	
	public Queue<String> getConsoleResults() {
		//for testing
		consoleResults.add("result 1");
		consoleResults.add("result 2");
		consoleResults.add("result 3");
		consoleResults.add("result 4");
		return consoleResults;
	}
	
	public void setVariableMap(HashMap<String,Double> variableMap) {
		this.variableMap=variableMap;
		//TODO
	}
	
	public HashMap<String,Double> getVariables() {
		variableMap.put("var1",3.0);
		variableMap.put("var2",4.0);
		variableMap.put("var3",5.0);
		
		return variableMap;
	}
	
	public void updateModel(Model model) {
		//update all fieds using data from controller
	}

}
