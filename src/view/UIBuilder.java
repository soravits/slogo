package view;

import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.text.Text;

public class UIBuilder{
	
	protected static int TURTLE_CANVAS_HEIGHT = 400;
	protected static int TURTLE_CANVAS_WIDTH = 530;
	protected static int WORKSPACE_HEIGHT = 400;
	protected static int COMMAND_LINE_WIDTH = 670;
	
	protected ResourceBundle uiResources;
	
	private static final String RESOURCE_FILE_NAME = "resources/DisplayedText";
	
	public UIBuilder(){
		this.uiResources = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	}
	
	
	protected Text getText(int x, int y, String t){
		Text text = new Text(t);
		text.setX(x);
		text.setY(y);
		return text;
	}
	
	protected Control setControlLayout(Control control, int x, int y, String style) {
		control.setLayoutX(x);
		control.setLayoutY(y);
		control.setFocusTraversable(false);
		control.getStyleClass().add(style);
		return control;
	}
	
	protected Button makeButton(int x, int y, String text, String style){
		Button button = new Button(text);
		button = (Button) setControlLayout(button, x, y, style);	
		return button;
		
	}
	
	
	
}