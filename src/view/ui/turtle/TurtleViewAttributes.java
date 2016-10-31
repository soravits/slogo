package view.ui.turtle;



import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class TurtleViewAttributes{
	
	private Paint penColor;
	private Image image;
	private ImageView iv;
	
	
	public TurtleViewAttributes(){
		this.penColor = Color.BLACK;
		this.image = new Image(getClass().getClassLoader().getResourceAsStream("resources/turtle.png"));
		this.iv = new ImageView(image);
		
		iv.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		        System.out.print(mouseEvent.getX());
		        System.out.print(mouseEvent.getY());

		    }
		});
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