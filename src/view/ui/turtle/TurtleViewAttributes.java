package view.ui.turtle;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class TurtleViewAttributes{
	
	private Paint penColor;
	private Image image;
	
	
	public TurtleViewAttributes(){
		this.penColor = Color.BLACK;
		this.image = new Image(getClass().getClassLoader().getResourceAsStream("resources/turtle.png"));
	}
	
	public Paint getPenColor(){
		return penColor;
	}
	
	public Image getImage(){
		return image;
	}
	
	public void setPenColor(Paint color){
		penColor = color; 
	}
	
	public void setImage(Image image){
		this.image = image;
	}
}