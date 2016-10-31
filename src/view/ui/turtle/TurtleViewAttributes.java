package view.ui.turtle;



import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class TurtleViewAttributes{
	
	private Paint penColor;
	private Image image;
	private ImageView iv;
	
	
	public TurtleViewAttributes(){
		this.penColor = Color.BLACK;
		this.image = new Image(getClass().getClassLoader().getResourceAsStream("resources/turtle.png"));
		this.iv = new ImageView(image);
		
		
	}
	
	public Paint getPenColor(){
		return penColor;
	}
	
	public ImageView getImage(){
		return iv;
		//return image;
	}
	
	public void setPenColor(Paint color){
		penColor = color; 
	}
	
	public void setImage(ImageView imageView){
		this.iv = imageView;
	}
}