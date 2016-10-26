package view.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.text.Text;

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