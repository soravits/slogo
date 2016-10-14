package visuals;
import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 * 
 * The purpose of this class is to display the interface that the user interacts with.
 * 
 * 
 * 
 * @author Diane Hadley
 */


public class UI {
	
	private ResourceBundle resources;
	private int xSize, ySize;
	
	private static final String RESOURCE_FILE_NAME = "resources/DisplayedText";
	private static final String CSS_FILE_NAME = "resources/UIStyling.css";
	
	/**
	 * constructor to set the size of the window and set the resource bundle to use
	 */
	public UI(int xSize, int ySize) {
		this.resources = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
		this.xSize = xSize;
		this.ySize = ySize;
	}

	
	/**
	 * Creates a root and initiates the scene. Main calls this method to start the program.
	 */
	public Scene init(){
		
		Group root = new Group();
		Scene scene = new Scene(root, xSize, ySize, Color.LIGHTGRAY);
		scene.getStylesheets().add(CSS_FILE_NAME);
		
		return scene;
		
		
	}
	
	
	
}