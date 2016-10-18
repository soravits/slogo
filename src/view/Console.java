package view;
import javafx.scene.Group;
import javafx.scene.control.TextArea;

/**
 * The purpose of this class is to create the root that visualizes the console.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */

public class Console {
	
	private Group root = new Group();
	
	
	public Console(){
		
	}
	
	
	
	/*
	 * returns root with all visualization of console
	 * 
	 */	
	public Group getRoot(){
		makeConsole();
		return root;
	}
	
	
	private void makeConsole(){
		TextArea console = new TextArea();
		console.setEditable(false);
	}
	
	
}

