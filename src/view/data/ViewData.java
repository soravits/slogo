package view.data;
import java.util.Collection;
import java.util.HashMap;

import controller.Controller;
import model.Model;
import model.TurtleMap;


/**
 *View External API is mainly responsible of sending data to the back end. 
 * @author Pim
 */
public class ViewData {
	private ViewModelInterface viewModelInterface;
	
	public ViewData() {
		this.viewModelInterface=new Model();
	}
	
	public void sendCommand(String command,Controller controller) throws Exception {
		controller.processCommand(command);	
	}
	
	public void updateViewModel(Model Model) {
		this.viewModelInterface=Model;
	}
	
	public TurtleMap getTurtleMap(){
		return viewModelInterface.getTurtleMap();
	}

	public Collection<Object> getIDs(){
		return viewModelInterface.getIDs();
	}
	
	public boolean getShowTurtle(Object id){
		return viewModelInterface.getShowTurtle(id);
	}
	
	public double getTurtleAngle(Object id){
    	return viewModelInterface.getTurtleAngle(id);
    }
	
	public double getTurtleX(Object id){
    	return viewModelInterface.getTurtleX(id);
    }
	
	public double getTurtleY(Object id){
    	return viewModelInterface.getTurtleY(id);
    }
	
	
	public boolean isPenDown(Object id){
    	return viewModelInterface.isPenDown(id);
    }
	
	
	
	public Collection<String> getConsoleReturn() {
		return viewModelInterface.getConsoleReturn();
	}
	
	public Collection<String> getCommandHistory() {
        return viewModelInterface.getCommandHistory();
    }
	
	public HashMap<String, Double> getWorkspace() {
		return viewModelInterface.getWorkspace().getListOfVariables();
	}
}
