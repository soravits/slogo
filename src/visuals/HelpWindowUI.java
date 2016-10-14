package visuals;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * The purpose of this class is to create the root that visualizes 
 * how the user gets to the help window.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */

public class HelpWindowUI{
	
	private Group root = new Group();
	private ResourceBundle helpResources;
	
	private Button helpButton;
	private final int helpButtonX = 10;
	private final int helpButtonY = 10;
	
	
	
	/**
	 * initiates HelpWindow and assigns resource bundle for instance
	 */
	public HelpWindowUI(ResourceBundle resources){
		helpResources = resources;
	}
	
	/**
	 * returns root with any UI for getting to help window from UI
	 * 
	 */		
	public Group getRoot(){		
		makeButton();
		return root;
		
	}
	
	private void makeButton(){

		helpButton = new Button(helpResources.getString("HelpButton"));
		addActionToButton();
		root.getChildren().add(formatControl(helpButton, helpButtonX, helpButtonY));
		
		
	}

	private void addActionToButton(){
		helpButton.setOnAction((event) -> {
			openHelpWindow();
		});		
	}
	
	
	private void openHelpWindow(){
		WebView helpWindow = new WebView();
		URL url = getClass().getResource("resources/helpWindow.html");
		helpWindow.getEngine().load(url.toString());
		Stage stage = new Stage();
		Scene scene = new Scene(helpWindow);		
		stage.setScene(scene);
		stage.show();
		
		
	}
	
	private Control formatControl(Control control, int x, int y) {
		control.setLayoutX(x);
		control.setLayoutY(y);
		control.setFocusTraversable(false);
		control.getStyleClass().add("helpcontrol");
		return control;
	}
	
}