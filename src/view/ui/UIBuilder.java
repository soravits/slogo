package view.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.text.Text;

/**
 * The purpose of this class is to provide methods that format text and controls in order to reduce
 * repeated code that would result from the many controls and Text instances used in the view
 * 
 * @author Diane
 * 
 */

public class UIBuilder{	
	
	public Text getText(int x, int y, String t){
		Text text = new Text(t);
		text.setX(x);
		text.setY(y);
		return text;
	}
	
	public Control setControlLayout(Control control, int x, int y, String style) {
		control.setLayoutX(x);
		control.setLayoutY(y);
		control.setFocusTraversable(false);
		control.getStyleClass().add(style);
		return control;
	}
	
	public Button makeButton(int x, int y, String text, String style){
		Button button = new Button(text);
		button = (Button) setControlLayout(button, x, y, style);	
		return button;
		
	}
	
	
	
}