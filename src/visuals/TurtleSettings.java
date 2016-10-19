package visuals;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * 
 * The purpose of this class is to display the interface the user can use to change settings
 * and to return the results of these settings
 * 
 * 
 * @author Diane
 *
 */


public interface TurtleSettings{
	
	
	/*
	 * returns the root with all visualizations of 
	 * how the user can update turtle settings
	 */
	public Group getRoot();
	
	
	/*
	 * returns the selected color of the background
	 * 
	 */
	public Color getBackgroundColor();
	
	
	/*
	 * returns the selected pen color
	 */
	public Color getPenColor();
	
	
	/*
	 * returns an Imageview of an image that was selected by the user
	 */
	public ImageView getTurtleImage();
	
	
}