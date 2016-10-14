import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public interface TurtleSettings{
	
	public Group getRoot();
	
	public Color getBackgroundColor();
	
	public Color getPenColor();
	
	public ImageView getTurtleImage();
	
	
}