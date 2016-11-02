package view.ui.turtle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
import view.DisplayError;
import view.ui.UIAttributes;
import view.ui.UIBuilder;

/**
 * 
 * The purpose of this class is to display the interface the user can use to change settings
 * and to return the results of these settings
 * 
 * 
 * @author Diane Hadley
 *
 */


public class TurtleSettings implements UIAttributes{
	
	private Group root = new Group();
	private UIBuilder uiBuilder = new UIBuilder();
	private DisplayError displayError;
	private ComboBox<Color> backgroundComboBox;
	private ComboBox<Color> penComboBox;
	private Stage stage;
	private Image turtleImage;
	private TurtleScreen turtle;
	
	
	private static final int COLOR_RECT_WIDTH = 75;
	private static final int COLOR_RECT_HEIGHT = 20;
	private static final int FIRST_CONTROL_Y = 80;
	private static final int CONTROL_Y_SPACING = 18;
	private static final int TEXT_SPACING = 6;
	
	
	
	private int controlX;
	
	public TurtleSettings(Stage stage, TurtleScreen turtle){
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
		initBackgroundColorComboBox();
		initPenColorComboBox();
		initPenTypeComboBox();
		initPenThicknessTextField();
		initActiveTurtleToggle();
		initColorPaletteButton();
		initImagePaletteButton();
		root.getChildren().addAll(
			uiBuilder.getText(controlX, FIRST_CONTROL_Y - TEXT_SPACING, uiResources.getString("TurtleBackgroundColor")),
			uiBuilder.getText(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*3 - TEXT_SPACING, uiResources.getString("TurtlePenColor")),
			uiBuilder.getText(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*6 - TEXT_SPACING, uiResources.getString("TurtlePenType")),
			uiBuilder.getText(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*9 - TEXT_SPACING, uiResources.getString("TurtlePenThickness")),
			uiBuilder.getText(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*12 - TEXT_SPACING, uiResources.getString("ActiveTurtleToggle"))
		);
		
		initImageButton();
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
	
	private void initBackgroundColorComboBox(){
		backgroundComboBox = new ComboBox<Color>();
		makeColorComboBox(backgroundComboBox, Color.WHITE, 0);
	}
	
	private void initPenColorComboBox(){
		penComboBox = new ComboBox<Color>();
		makeColorComboBox(penComboBox, Color.BLACK, 3);
	}
	
	private void makeColorComboBox(ComboBox<Color> comboBox, Color initColor, int yMultiplier){	
		addColorsToComboBox(comboBox);
		createGraphicsForComboBox(comboBox);	
		comboBox.setValue(initColor);
		
		comboBox.valueProperty().addListener(new ChangeListener<Color>() {
			@Override public void changed(ObservableValue color, Color c1, Color c2) {
				turtle.getRoot();
			}
		});		
		root.getChildren().add(uiBuilder.setControlLayout(comboBox, controlX, 
				FIRST_CONTROL_Y + CONTROL_Y_SPACING*yMultiplier, "turtlecontrol"));		
	}
	
	
	private void addColorsToComboBox(ComboBox<Color> comboBox){
		comboBox.getItems().addAll(Color.WHITE, Color.BLACK, Color.RED, 
				Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, 
				Color.DEEPSKYBLUE,
				Color.PURPLE, Color.PINK, Color.CORAL,
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
	
	
	private void initPenTypeComboBox(){
		
		ObservableList<String> penTypeOptions = FXCollections.observableArrayList(uiResources.getString("SolidLine"), 
				uiResources.getString("DashedLine"),uiResources.getString("DottedLine")); 
				

		ComboBox<String> penTypeComboBox = new ComboBox<String>(penTypeOptions);
		penTypeComboBox.setValue(uiResources.getString("SolidLine"));
		
		root.getChildren().add(uiBuilder.setControlLayout(penTypeComboBox, controlX, 
				FIRST_CONTROL_Y + CONTROL_Y_SPACING*6, "turtlecontrol"));
		
	}
	
	private void initPenThicknessTextField(){
		TextField penThickness = new TextField();
		root.getChildren().add(uiBuilder.setControlLayout(penThickness, controlX, 
				FIRST_CONTROL_Y + CONTROL_Y_SPACING*9, "turtlecontrol"));
	}
	
	private void initActiveTurtleToggle(){
		CheckBox showActiveTurtle = new CheckBox();
		root.getChildren().add(uiBuilder.setControlLayout(showActiveTurtle, controlX, 
				FIRST_CONTROL_Y + CONTROL_Y_SPACING*12, "turtlecontrol"));
	}
	
	
	private void initImageButton(){
		
		Button image = uiBuilder.makeButton(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*14, 
				uiResources.getString("Image"), "turtlecontrol");
		image.setOnAction((event) -> {
			chooseImage();
			turtle.updateViewMapImages();
			turtle.getRoot();
			
		});	
		
		root.getChildren().addAll(image);
	}
	
	private void initColorPaletteButton(){

		Button colorPalette = uiBuilder.makeButton(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*16, 
				uiResources.getString("ColorPaletteButton"), "turtlecontrol");
		colorPalette.setOnAction((event) -> {
			
		});	
		
		root.getChildren().add(colorPalette);
	}
	
	private void initImagePaletteButton(){
		Button imagePalette = uiBuilder.makeButton(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*18, 
				uiResources.getString("ImagePaletteButton"), "turtlecontrol");
		imagePalette.setOnAction((event) -> {
			
		});	
		
		root.getChildren().add(imagePalette);
		
	}
	
	private void chooseImage(){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(uiResources.getString("NewImageTitle"));
		ExtensionFilter filter = new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"); 	//http://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
		fileChooser.getExtensionFilters().add(filter);
		File selectedFile = fileChooser.showOpenDialog(stage);
		if (selectedFile != null){
			try {
				BufferedImage bufferedImage = ImageIO.read(selectedFile);	//http://java-buddy.blogspot.com/2013/01/use-javafx-filechooser-to-open-image.html
				turtleImage = SwingFXUtils.toFXImage(bufferedImage, null);
				
				
			} catch (IOException e) {
				displayError.displayErrorDialogueBox(uiResources.getString("InvalidTurtleImage"));
			}	
		}	
			
			
		
			
	}
	
}