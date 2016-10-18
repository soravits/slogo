package view;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Control;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Callback;

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
	private ComboBox<Color> backgroundComboBox;
	private ComboBox<Color> penComboBox;
	
	private static int COLOR_RECT_WIDTH = 75;
	private static int COLOR_RECT_HEIGHT = 20;
	private static int BACKGROUND_COLOR_COMBOBOX_Y = 100;
	private static int PEN_COLOR_COMBOBOX_Y = 175;
	
	private int colorComboBoxX;
	
	public TurtleSettings(ResourceBundle resources, int turtleWidth, UI ui){
		this.turtleResources = resources;
		this.ui = ui;
		this.colorComboBoxX = turtleWidth + 20;
	}
		
	
	/*
	 * returns the root with all visualizations of 
	 * how the user can update turtle settings
	 */
	public Group getRoot(){
		getBackgroundColorComboBox();
		addText(colorComboBoxX, BACKGROUND_COLOR_COMBOBOX_Y - 10, 
				turtleResources.getString("TurtleBackgroundColor"));
		
		getPenColorComboBox();
		addText(colorComboBoxX, PEN_COLOR_COMBOBOX_Y - 10, 
				turtleResources.getString("TurtlePenColor"));		
		return root;
	}
	
	
	/*
	 * returns the selected color of the background
	 * 
	 */
	public Paint getBackgroundColor(){
		Color color = backgroundComboBox.getSelectionModel().getSelectedItem();
		return color;
	}
	
	
	/*
	 * returns the selected pen color
	 */
	public Color getPenColor(){
		Color color = penComboBox.getSelectionModel().getSelectedItem();
		return color;
		
	}
	
	
	/*
	 * returns an ImageView of an image that was selected by the user
	 */
	public ImageView getTurtleImage(){		
		ImageView turtle = new ImageView();
		return turtle;
		
	}
	
	private void getBackgroundColorComboBox(){
		backgroundComboBox = new ComboBox<Color>();
		makeColorComboBox(backgroundComboBox, Color.WHITE, BACKGROUND_COLOR_COMBOBOX_Y);
	}
	
	private void getPenColorComboBox(){
		penComboBox = new ComboBox<Color>();
		makeColorComboBox(penComboBox, Color.BLACK, PEN_COLOR_COMBOBOX_Y);
	}
	
	private void makeColorComboBox(ComboBox<Color> comboBox, Color initColor, int y){	
		addColorsToComboBox(comboBox);
		createGraphicsForComboBox(comboBox);	
		comboBox.setValue(initColor);
		
		comboBox.valueProperty().addListener(new ChangeListener<Color>() {
			@Override public void changed(ObservableValue color, Color c1, Color c2) {
				ui.addTurtleToRoot();
			}
		});		
		root.getChildren().add(setControlLayout(comboBox, colorComboBoxX, y));		
	}
	
	
	private void addColorsToComboBox(ComboBox<Color> comboBox){
		comboBox.getItems().addAll(Color.WHITE, Color.BLACK, Color.RED, 
				Color.BLUE, Color.ORANGE, Color.GREEN,
				Color.ALICEBLUE, Color.ANTIQUEWHITE, 
				Color.AQUA, Color.AQUAMARINE, Color.AZURE);
	}
	
	private void createGraphicsForComboBox(ComboBox<Color> comboBox){
		comboBox.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>(){
			@Override public ListCell<Color> call(ListView<Color> p) {
				return new ListCell<Color>() {
					private final Rectangle r;
					{
						setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
						r = new Rectangle(COLOR_RECT_WIDTH, COLOR_RECT_HEIGHT);
					}
					@Override protected void updateItem(Color color, boolean empty) {
						super.updateItem(color, empty);
						if (color == null || empty) {
							setGraphic(null);
						}
						else{
							r.setFill(color);
							setGraphic(r);
						}
					}
				};
			}
		});
	}
	
	
	private void addText(int x, int y, String text) {
		Text t = new Text(x, y, text);
		root.getChildren().add(t);
	}
	
	
	private Control setControlLayout(Control control, int x, int y) {
		control.setLayoutX(x);
		control.setLayoutY(y);
		control.setFocusTraversable(false);
		control.getStyleClass().add("turtlecontrol");
		return control;
	}
	
	
}