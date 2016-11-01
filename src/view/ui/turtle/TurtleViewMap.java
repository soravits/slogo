package view.ui.turtle;

import java.util.Collection;
import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;

public class TurtleViewMap{
	
	private HashMap<Object, TurtleViewAttributes> turtleVisualMap;
	
	public TurtleViewMap(){
		turtleVisualMap = new HashMap<Object, TurtleViewAttributes>();
		//setAttributes(1);
	}
	
	public Collection<Object> getIDs(){
		return turtleVisualMap.keySet();
	}
	
	public Paint getPenColor(Object id){
		return turtleVisualMap.get(id).getPenColor();
	}
	
	public ImageView getImage(Object id){
		return turtleVisualMap.get(id).getImage();
	}
	
	public void setAttributes(Object id){
		TurtleViewAttributes attributes = new TurtleViewAttributes();
		turtleVisualMap.put(id, attributes);
	}
	
	public void setPenColor(Object id, Paint color){
		turtleVisualMap.get(id).setPenColor(color);
	}
	
//	public void setImage(Object id, Image image){
//		turtleVisualMap.get(id).setImage(image);
//	}
	public void setImage(Object id, ImageView image){
		turtleVisualMap.get(id).setImage(image);
	}
	
}