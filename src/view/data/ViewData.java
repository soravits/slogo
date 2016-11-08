package view.data;
import java.util.AbstractMap;
import java.util.Collection;
import controller.Controller;
import model.DisplayState;
import model.Model;
import model.TurtleMap;


/**
 *View External API is mainly responsible of sending data to the back end. 
 * @author Pim
 */

//This entire file is my masterpiece. - Pim Chuaylua pc131

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
	
	public AbstractMap<String, Double> getWorkspace() {
		return viewModelInterface.getWorkspace().getListOfVariables();
	}
	
	public DisplayState getDisplayState() {
		return viewModelInterface.getDisplay();
	}
	
	public double getPenColor () {
        return viewModelInterface.getPenColor();
    }
	
	public double getBackGround (){
		return viewModelInterface.getBackGround();
    }
	
	public double getPenSize () {
		return viewModelInterface.getPenSize();
    }
	
	public void setBackGround (int backIndex, Controller controller) throws Exception {
		
        sendCommand("setbackground " + backIndex, controller);
    }
	
	public void setPenSize (Double penSize, Controller controller) throws Exception {
		sendCommand("setpensize " +penSize.toString(), controller);
	}
	
	public void setPenColor (int pencolorIndex,Controller controller) throws Exception {
		sendCommand("setpencolor "+pencolorIndex,controller);
    }
	
	public void setShape (double pensize,Controller controller) throws Exception{
		sendCommand("setshape "+pensize,controller);
    }

}
