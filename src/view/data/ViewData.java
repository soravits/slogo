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

	public Collection<Double> getIDs(){
		return viewModelInterface.getIDs();
	}
	
	public boolean getShowTurtle(double id){
		return viewModelInterface.getShowTurtle(id);
	}
	
	public double getTurtleAngle(double id){
    	return viewModelInterface.getTurtleAngle(id);
    }
	
	public double getTurtleX(double id){
    	return viewModelInterface.getTurtleX(id);
    }
	
	public double getTurtleY(double id){
    	return viewModelInterface.getTurtleY(id);
    }
	
	
	public boolean isPenDown(double id){
    	return viewModelInterface.isPenDown(id);
    }
	
	public void changeActiveTurtle(double ID) {
        viewModelInterface.changeActiveTurtle(ID);
    }
	
	public double[][] getLines (double ID){
        return viewModelInterface.getLines(ID);
    }
	
	public Collection<Double> getTurtlesToModify () {
        return viewModelInterface.getTurtlesToModify();
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
