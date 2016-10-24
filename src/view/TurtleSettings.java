package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
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


public class TurtleSettings extends UIBuilder{
	
	private Group root = new Group();
	private DisplayError displayError;
	private ComboBox<Color> backgroundComboBox;
	private ComboBox<Color> penComboBox;
	private Stage stage;
	private Image turtleImage;
	private Turtle turtle;
	
	
	private static int COLOR_RECT_WIDTH = 75;
	private static int COLOR_RECT_HEIGHT = 20;
	private static int FIRST_CONTROL_Y = 100;
	private static int CONTROL_Y_SPACING = 60;
	
	
	private int controlX;
	
	public TurtleSettings(Stage stage, Turtle turtle){
		super();
		this.controlX = TURTLE_CANVAS_WIDTH + 20;
		this.stage = stage;
		this.turtle = turtle;
	}
		
	
	/*
	 * returns the root with all visualizations of 
	 * how the user can update turtle settings
	 */
	public Group getRoot(){
		getBackgroundColorComboBox();
		getPenColorComboBox();
		root.getChildren().addAll(
			getText(controlX, FIRST_CONTROL_Y - 10, uiResources.getString("TurtleBackgroundColor")),
			getText(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*1 -10, uiResources.getString("TurtlePenColor"))	
		);
		
		getButtons();
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
	 * returns an image that was selected by the user
	 */

	public Image getTurtleImage(){
		return turtleImage;
	}
	
	private void getBackgroundColorComboBox(){
		backgroundComboBox = new ComboBox<Color>();
		makeColorComboBox(backgroundComboBox, Color.WHITE, 0);
	}
	
	private void getPenColorComboBox(){
		penComboBox = new ComboBox<Color>();
		makeColorComboBox(penComboBox, Color.BLACK, 1);
	}
	
	private void makeColorComboBox(ComboBox<Color> comboBox, Color initColor, int yMultiplier){	
		addColorsToComboBox(comboBox);
		createGraphicsForComboBox(comboBox);	
		comboBox.setValue(initColor);
		
		comboBox.valueProperty().addListener(new ChangeListener<Color>() {
			@Override public void changed(ObservableValue color, Color c1, Color c2) {
				turtle.getRoot();
				//ui.addTurtleToRoot();
			}
		});		
		root.getChildren().add(setControlLayout(comboBox, controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*yMultiplier, "turtlecontrol"));		
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
	
	
	private void getButtons(){
//		Button reset = makeButton(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*3, 
//				uiResources.getString("ResetTurtle"), "turtlecontrol");
//		reset.setOnAction((event) -> {
//			turtle.resetTurtle();
//			turtle.getRoot();
//		});	
		
		Button image = makeButton(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*2, 
				uiResources.getString("Image"), "turtlecontrol");
		image.setOnAction((event) -> {
			chooseImage();
			turtle.getRoot();
			
		});	
		
		root.getChildren().addAll(image);
	}
	
	private void chooseImage(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Image File");
		ExtensionFilter filter = new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"); 	//http://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
		fileChooser.getExtensionFilters().add(filter);
		File selectedFile = fileChooser.showOpenDialog(stage);
		
		try {
			BufferedImage bufferedImage = ImageIO.read(selectedFile);	//http://java-buddy.blogspot.com/2013/01/use-javafx-filechooser-to-open-image.html
			turtleImage = SwingFXUtils.toFXImage(bufferedImage, null);
		} catch (IOException e) {
			displayError.displayErrorDialogueBox("File selected is not a valid image file");
		}	
				
	}
	
}