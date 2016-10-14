import javafx.scene.Group;

/**
 * The purpose of this class is to create the root that visualizes the workspace.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */


public interface Workspace{
	
	/*
	 * returns root with all visualization of the workspace
	 * 
	 */	
	public Group getRoot();
	
	
	
}