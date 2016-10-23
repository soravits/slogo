package view.data;

import java.util.HashMap;


/**
 *View External API is mainly responsible of sending data to the back end. 
 * @author Pim
 */
public class DataIn {
	String command;
	String language;
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command=command;
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
	
	public void setVariables() {
		//TODO
	}
	
	public HashMap<String,Double> getVariables() {
		//TODO
		return null;
	}
	
	
	public void update() {
		//update all fields using data from UI
	}
}
