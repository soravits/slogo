package view.ui.turtle;

import java.util.Collection;
import java.util.HashMap;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;

public class TurtleViewMap{
	
	private HashMap<Double, TurtleViewAttributes> turtleVisualMap;
	
	public TurtleViewMap(){
		turtleVisualMap = new HashMap<Double, TurtleViewAttributes>();
	}
	
	public Collection<Double> getIDs(){
		return turtleVisualMap.keySet();
	}
	
	public Paint getPenColor(Double id){
		return turtleVisualMap.get(id).getPenColor();
	}
	
	public ImageView getImage(Double id){
		return turtleVisualMap.get(id).getImage();
	}
	
	public void setAttributes(Double id){
		TurtleViewAttributes attributes = new TurtleViewAttributes();
		turtleVisualMap.put(id, attributes);
	}
	
	public void setPenColor(Double id, Paint color){
		turtleVisualMap.get(id).setPenColor(color);
	}
	
	public void setImage(Double id, ImageView image){
		turtleVisualMap.get(id).setImage(image);
	}
	
}