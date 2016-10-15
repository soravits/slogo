package visuals;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * 
 * The purpose of this class is to display the interface the user can use to change settings
 * and to return the results of these settings
 * 
 * 
 * @author Diane Hadley
 *
 */


public class TurtleSettings{
	
	private Group root = new Group();
	private ResourceBundle turtleResources;	
	private UI ui;
	//private Turtle turtle;
	private ComboBox<Rectangle> backgroundComboBox;
	
	public TurtleSettings(ResourceBundle resources, UI ui){
		this.turtleResources = resources;
		//this.turtle = turtle;
		this.ui = ui;
	}
	
	
	
	/*
	 * returns the root with all visualizations of 
	 * how the user can update turtle settings
	 */
	public Group getRoot(){
		makeBackgroundColorComboBox();
		return root;
	}
	
	
	/*
	 * returns the selected color of the background
	 * 
	 */
	public Paint getBackgroundColor(){
		Rectangle colorRect = backgroundComboBox.getSelectionModel().getSelectedItem();
		return colorRect.getFill();
//		Color color = Color.WHITE;
//		return color;
	}
	
	
	/*
	 * returns the selected pen color
	 */
	public Color getPenColor(){
		Color color = Color.WHITE;
		return color;
	}
	
	
	/*
	 * returns an ImageView of an image that was selected by the user
	 */
	public ImageView getTurtleImage(){
		
		ImageView turtle = new ImageView();
		return turtle;
		
	}
	
	private void makeBackgroundColorComboBox(){
			
		ObservableList<Rectangle> backgroundOptions = makeColorList();			
		
		
		backgroundComboBox = new ComboBox<Rectangle>(backgroundOptions);
		//backgroundComboBox.setValue(turtleResources.getString("TurtleBackgroundColor"));
		
		backgroundComboBox.setValue(backgroundOptions.get(0));
		
		backgroundComboBox.valueProperty().addListener(new ChangeListener<Rectangle>() {
			@Override public void changed(ObservableValue rect, Rectangle r1, Rectangle r2) {
				ui.addTurtleToRoot();
			}
		});
		
		
		
		root.getChildren().add(setControlLayout(backgroundComboBox, 550, 100));
	}
	
	
	
	private Control setControlLayout(Control control, int x, int y) {
		control.setLayoutX(x);
		control.setLayoutY(y);
		control.setFocusTraversable(false);
		control.getStyleClass().add("turtlecontrol");
		return control;
	}
	
	private ObservableList<Rectangle> makeColorList(){
		
		ObservableList<Rectangle> colors = FXCollections.observableArrayList();
		
		Rectangle rect = new Rectangle();
		rect.setWidth(75);
		rect.setHeight(20);
		rect.setFill(Color.BLUE);	
		colors.add(rect);
		
		Rectangle rect2 = new Rectangle();
		rect2.setWidth(75);
		rect2.setHeight(20);
		rect2.setFill(Color.RED);	
		colors.add(rect2);
		
		return colors;
		
	}
	
}