// This entire file is part of my masterpiece.
// DIANE HADLEY


package view.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.text.Text;

/**
 * The purpose of this class is to provide methods that format text and controls in order to reduce
 * repeated code that would result from the many controls and Text instances used in the view
 * 
 * I think it is well designed because it reduces code in a very simple, clean, and easy to use way
 * 
 * @author Diane Hadley
 * 
 */

public class UIBuilder{	
	
	/**
	 * Creates a Text object and sets its contents and location
	 * returns the Text object
	 * @param x
	 * @param y
	 * @param t
	 */
	public Text getText(int x, int y, String t){
		Text text = new Text(t);
		text.setX(x);
		text.setY(y);
		return text;
	}
	
	/**
	 * Sets the location and style of a control object
	 * returns the control
	 * @param control
	 * @param x
	 * @param y
	 * @param style
	 * @return
	 */
	public Control setControlLayout(Control control, int x, int y, String style) {
		control.setLayoutX(x);
		control.setLayoutY(y);
		control.setFocusTraversable(false);
		control.getStyleClass().add(style);
		return control;
	}
	
	/**
	 * Creates a button and sets its location and style
	 * returns the button
	 * @param x
	 * @param y
	 * @param text
	 * @param style
	 * @return
	 */
	public Button makeButton(int x, int y, String text, String style){
		Button button = new Button(text);
		button = (Button) setControlLayout(button, x, y, style);	
		return button;
		
	}
	
	
	
}