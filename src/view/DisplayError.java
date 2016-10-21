package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * 
 * the purpose of this class is to display an error that is caught in the front end
 * 
 * @author Diane Hadley
 *
 */

public class DisplayError{

	
	
	/**
	 * displays a dialogue box that describes the error
	 * 
	 */
	public void displayErrorDialogueBox(String error){
		Alert dialogueBox = new Alert(AlertType.ERROR);
		dialogueBox.setContentText(error);
		dialogueBox.show();
		
	};
	
}