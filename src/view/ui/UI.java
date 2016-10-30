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
 * The purpose of this class is to display the interface that the user interacts with.
 * 
 * @author Diane Hadley
 */
public class UI implements UIAttributes{
	
	
	private UIBuilder uiBuilder = new UIBuilder();
	private int xSize, ySize;
	private Stage stage;
	public GeneralSettings generalSettings;
	private TabPane tabPane = new TabPane();
	private Group tabArea = new Group();
	
	
	
	private static final String CSS_FILE_NAME = "resources/UIStyling.css";
	
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
				
		Scene scene = new Scene(root, xSize, ySize, Color.LIGHTGREY);
		scene.getStylesheets().add(CSS_FILE_NAME);
		
		AnchorPane anchor = new AnchorPane();
		anchor.getStyleClass().add("pane");
		root.getStyleClass().add("pane");
		
		AnchorPane.setTopAnchor(tabArea, 0.0);
        AnchorPane.setRightAnchor(tabArea, 10.0);
        AnchorPane.setTopAnchor(tabPane, 0.0);
        AnchorPane.setRightAnchor(tabPane, 0.0);
        AnchorPane.setLeftAnchor(tabPane, 0.0);
        AnchorPane.setBottomAnchor(tabPane, 0.0);	
        
		anchor.getChildren().addAll(tabPane, tabArea);
		
		root.setCenter(anchor);
		
		makeWindow(false);
		makeNewTabButton();
		return scene;
		
	}
	
	private void makeWindow(Boolean isClosable){
		Window window = new Window(stage, xSize, ySize);
		Group root = window.getRoot();
			
		Tab tab = new Tab();
		tab.setClosable(isClosable);
		tab.setContent(root);
		tabPane.getTabs().add(tab);	
	}
	
	
	private void makeNewTabButton(){
		Button newTab = uiBuilder.makeButton(xSize - 10, 10, uiResources.getString("NewTab"),
				"tabcontrol");
		
		newTab.setOnAction((event) -> {
			makeWindow(true);
		});	
		
		tabArea.getChildren().add(newTab);
	}
	
	
//	private void resetAll() {
//		controller.reset();
//		model = dataIn.getViewModel();
//		turtleScreen.updateTurtles(model.getTurtleMap());
//		console.updateConsole(model.getConsoleReturn());
//		workspace.updateWorkspace(model.getWorkspace());
//		workspace.getRoot();
//		console.getRoot();
//	}
	
	
	
	
	
	
}