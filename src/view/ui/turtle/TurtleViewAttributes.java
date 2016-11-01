package view.ui.turtle;



import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class TurtleViewAttributes{
	
	private Paint penColor;
	private ImageView iv;
	
	
	public TurtleViewAttributes(){
		this.penColor = Color.BLACK;
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("resources/turtle.png"));
		this.iv = new ImageView(image);
		
		
	}
	
	public Paint getPenColor(){
		return penColor;
	}
	
	public ImageView getImage(){
		return iv;
	}
	
	public void setPenColor(Paint color){
		penColor = color; 
	}
	
	public void setImage(ImageView imageView){
		this.iv = imageView;
	}
}