package view.ui.turtle;

import java.util.Collection;
import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The purpose of this class is to store, set, and get which image is associated with each turtle index
 * 
 * @author Diane Hadley
 *
 */

public class TurtleViewMap{
	
	private HashMap<Double, ImageView> turtleVisualMap;
	
	public TurtleViewMap(){
		turtleVisualMap = new HashMap<Double, ImageView>();
	}
	
	/**
	 * @return all ids that are keys in the map
	 */
	public Collection<Double> getIDs(){
		return turtleVisualMap.keySet();
	}
	
	/**
	 * @param id
	 * @return the ImageView that is mapped to the turtle index id
	 */
	public ImageView getImage(Double id){
		return turtleVisualMap.get(id);
	}
	
	/**
	 * @param id
	 * map default turtle image to new turtle id
	 */
	public void setAttributes(Double id){
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("resources/turtle.png"));
		turtleVisualMap.put(id, new ImageView(image));
	}

	/**
	 * @param id
	 * @param image
	 * map image to turtle id
	 */
	public void setImage(Double id, ImageView image){
		turtleVisualMap.put(id, image);
	}
	
}