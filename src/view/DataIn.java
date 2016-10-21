package view;


/**
 *View External API is mainly responsible of sending data to the back end and receiving data from the backend. 
 * @author Pim
 */
public class DataIn {
	String command;
	String language;
	
	public String getCommand() {
		return command;
	}
	public void addCommand(String command) {
		this.command=command;
	}
	
	public void addLanguage(String language) {
		//getting language from settings
	}
	
	public String getLanguage() {
		return language;
	}
}
