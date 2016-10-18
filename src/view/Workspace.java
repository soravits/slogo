package view;
import javafx.scene.Group;
import javafx.scene.control.TextArea;

/**
 * The purpose of this class is to create the root that visualizes the workspace.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */


public class Workspace{
	
	private Group root = new Group();
	
	
	public Workspace(){
		
		
	}
	
	
	/*
	 * returns root with all visualization of the workspace
	 * 
	 */	
	public Group getRoot(){
		return root;
	}
	
	
	private void makeWorkspace(){
		TextArea workspace = new TextArea();
	}
	
	
}