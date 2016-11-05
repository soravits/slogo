package view.ui;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * 
 * The purpose of this class is to build the scene and hold the different windows
 * which have the interface that the user interacts with.
 * 
 * @author Diane Hadley
 */
public class UI implements UIAttributes{
		
	private int xSize, ySize;
	private Stage stage;
	public GeneralSettings generalSettings;
	private TabPane tabPane = new TabPane();
	private Group tabArea = new Group();
	private UIBuilder uiBuilder = new UIBuilder();
	
	private static final String CSS_FILE_NAME = "resources/UIStyling.css";
	private static final boolean FIRST_WINDOW_IS_CLOSABLE = false;
	private static final boolean NEW_WINDOW_IS_CLOSABLE = true;
	
	
	/**
	 * constructor to set the size of the window and set the resource bundle to use
	 */
	public UI(int xSize, int ySize, Stage stage) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.stage = stage;
	}
	
	
	
	/**
	 * Creates a root and initiates the scene. Main calls this method to start the program.
	 */
	public Scene init(){
		
		BorderPane root = new BorderPane();
		root.getStyleClass().add("pane");
				
		Scene scene = new Scene(root, xSize, ySize, Color.LIGHTGREY);
		scene.getStylesheets().add(CSS_FILE_NAME);
		
		AnchorPane anchor = new AnchorPane();
		anchor.getStyleClass().add("pane");		
		setAnchorBorders();	     
		anchor.getChildren().addAll(tabPane, tabArea);
		
		root.setCenter(anchor);
		
		initWindow(FIRST_WINDOW_IS_CLOSABLE);
		initNewWindowButton();
		return scene;		
	}

	private void setAnchorBorders() {
		AnchorPane.setTopAnchor(tabArea, 0.0);
        AnchorPane.setRightAnchor(tabArea, 10.0);
        AnchorPane.setTopAnchor(tabPane, 0.0);
        AnchorPane.setRightAnchor(tabPane, 0.0);
        AnchorPane.setLeftAnchor(tabPane, 0.0);
        AnchorPane.setBottomAnchor(tabPane, 0.0);
	}
	
	private void initWindow(Boolean isClosable){
		Window window = new Window(stage, xSize, ySize);
		Group root = window.getRoot();		
		Tab tab = new Tab();
		tab.setClosable(isClosable);
		tab.setContent(root);
		tabPane.getTabs().add(tab);	
	}
	
	
	private void initNewWindowButton(){
		Button newWindowButton = uiBuilder.makeButton(xSize - 10, 10, uiResources.getString("NewTab"),
				"tabcontrol");
		
		newWindowButton.setOnAction((event) -> {
			initWindow(NEW_WINDOW_IS_CLOSABLE);
		});	
		
		tabArea.getChildren().add(newWindowButton);
	}
	
}