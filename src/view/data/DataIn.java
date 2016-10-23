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
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command=command;
	}

	public void parseCommand(Controller Controller) {
		Controller.processCommand(command);
	}
	
	public void setLanguage(String language) {
		//getting language from settings
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setTurtlePos() {
		//TODO
	}
	
	public Object getTurtlePos() {
		//TODO
		return null;
	}
	
	public void setVariables(HashMap<String,Double> variableMap) {
		//TODO
	}
	
	public HashMap<String,Double> getVariables() {
		//TODO
		return null;
	}
	
	
	public void updateModel(Model model) {
		//update all fields using data from UI
	}
}
