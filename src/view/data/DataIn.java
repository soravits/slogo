package view.data;

import java.util.HashMap;

import controller.Controller;
import model.Model;


/**
 *View External API is mainly responsible of sending data to the back end. 
 * @author Pim
 */
public class DataIn {
	private String command;
	private String language;
	
	public DataIn() {
	}
	
	public void setCommand(String command) {
		this.command=command;
	}
	
	public void setLanguage(String language) {
		this.language=language;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getLanguage() {
		return language;
	}

	public void parseCommand(Controller controller) throws Exception {
		controller.processCommand(command);
	}
	
	public void setTurtlePos() {
		//TODO
	}
	
	public void setVariables(HashMap<String,Double> variableMap) {
		//TODO
	}
	
	public void updateModel(Model model) {
		//update all fields using data from UI
	}
}
