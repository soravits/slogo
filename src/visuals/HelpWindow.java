package visuals;
import javafx.scene.Group;

/**
 * The purpose of this class is to create the root that visualizes 
 * how the user gets to the help window.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */

public interface HelpWindow{
	
	
	/*
	 * returns root with any UI for getting to help window from UI
	 * 
	 */	
	public Group getRoot();
	

	
}