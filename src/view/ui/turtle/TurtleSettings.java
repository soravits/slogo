package view.ui.turtle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
import view.DisplayError;
import view.data.ViewData;
import view.ui.UIAttributes;
import view.ui.UIBuilder;

/**
 * 
 * The purpose of this class is to display the interface the user can use to change settings
 * and to return the results of these settings
 * 
 * @author Diane Hadley
 *
 */


public class TurtleSettings implements UIAttributes{
	
	private Group root = new Group();
	private UIBuilder uiBuilder = new UIBuilder();
	private DisplayError displayError = new DisplayError();
	private ComboBox<Color> backgroundComboBox;
	private ComboBox<Color> penComboBox;
	private CheckBox showActiveTurtle;
	private Stage stage;
	private Image turtleImage;
	private TurtleScreen turtle;
	private TextField penThicknessTextField;
	private ViewData viewData;
	private Controller controller;
	
	private Map<Integer, Color> indexColorMap;
	private Map<Integer, Image> indexImageMap;	
	
	private static final int COLOR_RECT_WIDTH = 75;
	private static final int COLOR_RECT_HEIGHT = 20;
	private static final int FIRST_CONTROL_Y = 80;
	private static final int CONTROL_Y_SPACING = 18;
	private static final int TEXT_SPACING = 6;
	private static final double DEFAULT_THICKNESS = 1.0;
	private static final int START_PALETTE_Y = 10;
	private static final int PALETTE_Y_MULTIPLIER = 30;
	private static final int PALETTE_X = 10;
	private static final int PALETTE_WINDOW_SIZE = 200;
	
	private int controlX;
	
	public TurtleSettings(Stage stage, TurtleScreen turtle, ViewData viewData, Controller controller){
		super();
		this.controlX = TURTLE_CANVAS_WIDTH + 20;
		this.viewData = viewData;
		this.stage = stage;
		this.turtle = turtle;
		this.controller = controller;
		initColorMap();
		initImageMap();
		initRoot();
	}

	/**
	 * returns the root with all visualizations of 
	 * how the user can update turtle settings
	 */
	public Group getRoot(){	
		return root;
	}
	
	
	/**
	 * returns the selected color of the background
	 * 
	 */
	public Paint getBackgroundColor(){
		Color color = backgroundComboBox.getSelectionModel().getSelectedItem();
		return color;
	}
	
	/**
	 * returns the selected pen color
	 */
	public Color getPenColor(){
		Color color = penComboBox.getSelectionModel().getSelectedItem();
		return color;		
	}
	
	
	/**
	 * returns an image that was selected by the user
	 */
	public Image getTurtleImage(){
		return turtleImage;
	}
	
	/**
	 * returns a double that determines the thickness of the 
	 * pen that draws the turtle's path
	 */
	public double getPenThickness(){	
		String thicknessString = penThicknessTextField.getText();
		if (thicknessString.equals("")){
			return viewData.getPenSize();
		}	
		else {				
			try {
				return setPenThickness(thicknessString);
			}catch(Exception e){
				displayError.displayErrorDialogueBox(uiResources.getString("InvalidPenThickness"));			
			}			
		}
		return DEFAULT_THICKNESS;	
	}

	/**
	 * return boolean to determine if user can graphically see which
	 * turtles are active
	 */
	public boolean getActiveTurtleToggle(){
		return showActiveTurtle.isSelected();
	}
	
	private double setPenThickness(String thicknessString) throws Exception {
		double thickness = Double.parseDouble(thicknessString);
		if (thickness != viewData.getPenSize()){
			viewData.setPenSize(thickness, controller);
		}				
		return thickness;
	}
	
	private void initColorMap(){
		indexColorMap = new HashMap<Integer, Color>();
		indexColorMap.put(1, Color.BLACK);
		indexColorMap.put(2, Color.RED);
		indexColorMap.put(3, Color.ORANGE);	
	}
	
	private void initImageMap(){
		indexImageMap = new HashMap<Integer, Image>();
		indexImageMap.put(1, new Image(getClass().getClassLoader().getResourceAsStream("resources/turtle.png")));
		indexImageMap.put(2, new Image(getClass().getClassLoader().getResourceAsStream("resources/fish_happy.png")));
		indexImageMap.put(3, new Image(getClass().getClassLoader().getResourceAsStream("resources/frog.png")));	
	}
	
	private void initRoot() {
		initBackgroundColorComboBox();
		initPenColorComboBox();
		initPenTypeComboBox();
		initPenThicknessTextField();
		initActiveTurtleToggle();
		initColorPaletteButton();
		initImagePaletteButton();
		initImageButton();
		root.getChildren().addAll(
				uiBuilder.getText(controlX, FIRST_CONTROL_Y - TEXT_SPACING, uiResources.getString("TurtleBackgroundColor")),
				uiBuilder.getText(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*3 - TEXT_SPACING, uiResources.getString("TurtlePenColor")),
				uiBuilder.getText(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*6 - TEXT_SPACING, uiResources.getString("TurtlePenType")),
				uiBuilder.getText(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*9 - TEXT_SPACING, uiResources.getString("TurtlePenThickness")),
				uiBuilder.getText(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*12 - TEXT_SPACING, uiResources.getString("ActiveTurtleToggle"))
			);
	}
	
	private void initBackgroundColorComboBox(){
		backgroundComboBox = new ComboBox<Color>();
		makeColorComboBox(backgroundComboBox, Color.WHITE, 0);
		backgroundComboBox.valueProperty().addListener(new ChangeListener<Color>() {
			@Override public void changed(ObservableValue color, Color c1, Color c2) {
				try {
					turtle.getRoot();
					viewData.setBackGround(5, controller);
				} catch (Exception e) {
					displayError.displayErrorDialogueBox(uiResources.getString("Error"));
				}
				
			}
		});
	}
	
	private void initPenColorComboBox(){
		penComboBox = new ComboBox<Color>();
		makeColorComboBox(penComboBox, Color.BLACK, 3);	
	}
	
	private void makeColorComboBox(ComboBox<Color> comboBox, Color initColor, int yMultiplier){	
		addColorsToComboBox(comboBox);
		createGraphicsForComboBox(comboBox);	
		comboBox.setValue(initColor);
				
		root.getChildren().add(uiBuilder.setControlLayout(comboBox, controlX, 
				FIRST_CONTROL_Y + CONTROL_Y_SPACING*yMultiplier, "turtlecontrol"));		
	}
	
	
	private void addColorsToComboBox(ComboBox<Color> comboBox){
		comboBox.getItems().addAll(Color.BLACK, Color.RED, Color.ORANGE);
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
		penTypeComboBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue string, String s1, String s2) {
				
			}
		});		
		root.getChildren().add(uiBuilder.setControlLayout(penTypeComboBox, controlX, 
				FIRST_CONTROL_Y + CONTROL_Y_SPACING*6, "turtlecontrol"));		
	}
	
	private void initPenThicknessTextField(){
		penThicknessTextField = new TextField();		
		root.getChildren().add(uiBuilder.setControlLayout(penThicknessTextField, controlX, 
				FIRST_CONTROL_Y + CONTROL_Y_SPACING*9, "turtlecontrol"));
	}
	
	private void initActiveTurtleToggle(){
		showActiveTurtle = new CheckBox();
		showActiveTurtle.setSelected(false);	
		showActiveTurtle.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {			
				turtle.setActiveTurtleToggle();
				
				turtle.getRoot();
			}
		});					
		root.getChildren().add(uiBuilder.setControlLayout(showActiveTurtle, controlX, 
				FIRST_CONTROL_Y + CONTROL_Y_SPACING*12, "turtlecontrol"));
	}
	
	
	private void initImageButton(){		
		Button image = uiBuilder.makeButton(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*14, 
				uiResources.getString("Image"), "turtlecontrol");
		image.setOnAction((event) -> {
			chooseImage();		
			turtle.getRoot();		
		});			
		root.getChildren().addAll(image);
	}
	
	private void initColorPaletteButton(){
		Button colorPalette = uiBuilder.makeButton(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*16, 
				uiResources.getString("ColorPaletteButton"), "turtlecontrol");
		colorPalette.setOnAction((event) -> {
			Stage stage = new Stage();
			Group root = new Group();				
			for (Integer index: indexColorMap.keySet()){		
				displayColorAndIndex(root, index);			
			}
			Scene scene = new Scene(root, PALETTE_WINDOW_SIZE, PALETTE_WINDOW_SIZE);
			stage.setScene(scene);
			stage.show();
		});	
		root.getChildren().add(colorPalette);
	}

	private void displayColorAndIndex(Group root, Integer index) {
		Rectangle rect = new Rectangle();
		rect.setHeight(COLOR_RECT_HEIGHT);
		rect.setWidth(COLOR_RECT_WIDTH);
		rect.setX(PALETTE_X);
		rect.setY(START_PALETTE_Y + PALETTE_Y_MULTIPLIER*(index-1));
		rect.setFill(indexColorMap.get(index));
		Text t = new Text(index.toString());
		t.setX(PALETTE_X*2 + COLOR_RECT_WIDTH);
		t.setY(START_PALETTE_Y + PALETTE_Y_MULTIPLIER*(index-1) + 15);
		root.getChildren().addAll(t, rect);
	}
	
	private void initImagePaletteButton(){
		Button imagePalette = uiBuilder.makeButton(controlX, FIRST_CONTROL_Y + CONTROL_Y_SPACING*18, 
				uiResources.getString("ImagePaletteButton"), "turtlecontrol");
		imagePalette.setOnAction((event) -> {
			Stage stage = new Stage();
			Group root = new Group();					
			for (Integer index: indexImageMap.keySet()){		
				displayImageAndIndex(root, index);			
			}		
			Scene scene = new Scene(root, PALETTE_WINDOW_SIZE, PALETTE_WINDOW_SIZE);
			stage.setScene(scene);
			stage.show();
		});		
		root.getChildren().add(imagePalette);
		
	}

	private void displayImageAndIndex(Group root, Integer index) {
		ImageView iv = new ImageView(indexImageMap.get(index));
		iv.setX(PALETTE_X);
		iv.setY(START_PALETTE_Y + PALETTE_Y_MULTIPLIER*2*(index-1));
		iv.setFitHeight(COLOR_RECT_HEIGHT*2);
		iv.setFitWidth(COLOR_RECT_HEIGHT*2);		
		Text t = new Text(index.toString());
		t.setX(PALETTE_X*2 + COLOR_RECT_WIDTH);
		t.setY(START_PALETTE_Y + PALETTE_Y_MULTIPLIER*2*(index-1) + 20);
		root.getChildren().addAll(t, iv);
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
				turtle.updateViewMapImages();
				
			} catch (IOException e) {
				displayError.displayErrorDialogueBox(uiResources.getString("InvalidTurtleImage"));
			}	
		}	
			
	}
	
}