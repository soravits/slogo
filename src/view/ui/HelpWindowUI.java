package view.ui;
import java.net.URL;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * The purpose of this class is to create the root that visualizes 
 * how the user gets to the help window.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */

public class HelpWindowUI implements UIAttributes{
	
	private Group root = new Group();
	private UIBuilder uiBuilder = new UIBuilder();
	
	private static final String HTML_FILE_NAME = "resources/HelpWindow.html";
	
	private Button helpButton;
	private final int helpButtonX = 10;
	private final int helpButtonY = 10;
	
	/**
	 * initiates HelpWindow and assigns resource bundle for instance
	 */
	public HelpWindowUI(){
		super();
	}
	
	/**
	 * returns root with any UI for getting to help window from UI
	 * 
	 */		
	public Group getRoot(){		
		getButton();
		return root;
		
	}
	
	private void getButton(){
		
		helpButton = uiBuilder.makeButton(helpButtonX, helpButtonY, uiResources.getString("HelpButton"), "helpcontrol");
		addActionToButton();
		root.getChildren().add(helpButton);
		
		
	}

	private void addActionToButton(){
		helpButton.setOnAction((event) -> {
			openHelpWindow();
		});		
	}
	
	
	private void openHelpWindow(){
		WebView helpWindow = new WebView();
		URL url = getClass().getClassLoader().getResource(HTML_FILE_NAME);
		helpWindow.getEngine().load(url.toString());
		Stage stage = new Stage();
		stage.setResizable(true);
		Scene scene = new Scene(helpWindow);		
		stage.setScene(scene);
		stage.show();	
	}
	
}