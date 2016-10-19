package visuals;
import javafx.scene.Group;

/**
 * The purpose of this class is to create the root that visualizes the console.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */

public interface Console {
	
	
	/*
	 * returns root with all visualization of console
	 * 
	 */	
	public Group getRoot();
	
}