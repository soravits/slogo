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
	private Model viewModel;
	
	public DataIn(Model model) {
		this.viewModel=model;
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

	public void parseCommand(Controller controller) throws Exception {
		controller.processCommand(command);
	}
	
	public void updateViewModel(Model Model) {
		this.viewModel=Model;
	}
	
	public Model getViewModel() {
		return viewModel;
	}
}
