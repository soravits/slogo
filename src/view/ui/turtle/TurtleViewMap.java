package view.ui.turtle;

import java.util.Collection;
import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleViewMap{
	
	private HashMap<Double, ImageView> turtleVisualMap;
	
	public TurtleViewMap(){
		turtleVisualMap = new HashMap<Double, ImageView>();
	}
	
	public Collection<Double> getIDs(){
		return turtleVisualMap.keySet();
	}
	
	
	public ImageView getImage(Double id){
		return turtleVisualMap.get(id);
	}
	
	public void setAttributes(Double id){
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("resources/turtle.png"));
		turtleVisualMap.put(id, new ImageView(image));
	}

	
	public void setImage(Double id, ImageView image){
		turtleVisualMap.put(id, image);
	}
	
}