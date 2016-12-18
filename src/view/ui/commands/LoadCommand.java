package view.ui.commands;
import java.io.File;
import java.io.IOException;
import controller.Controller;
import error.InvalidCommandException;
import error.InvalidParametersException;
import error.InvalidSyntaxException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import view.ui.UIAttributes;
import view.ui.Window;
import javafx.stage.Stage;

/**This class is to provide a button to be added to the UI to load command on text file
 * 
 * @author Pim Chuaylua
 *
 */


public class LoadCommand implements UIAttributes{
	private static int BUTTON_X = 320;
	private static int BUTTON_Y = 10;
	private Group root;
	private Button loadButton;
	private Stage stage;
	private Window window;
	private Controller controller;
	
	public LoadCommand(Window window) {
		this.root = new Group();
		this.stage = new Stage();
		this.window = window;
		this.controller = window.getController();
		initLoadCommandButton();
	}
	
	public Button getRoot() {
		return loadButton;
	}
	
	public void initLoadCommandButton() {
		loadButton = new Button(uiResources.getString("LoadCommand"));
		loadButton.setLayoutX(BUTTON_X);
		loadButton.setLayoutY(BUTTON_Y);
		loadButton.getStyleClass().add("generalcontrol");
		
		loadButton.setOnAction(new EventHandler<ActionEvent>(){
			 
            @Override
            public void handle(ActionEvent arg0) {
            	FileChooser fileChooser = new FileChooser();
        		fileChooser.setTitle("Choose File");
        		ExtensionFilter filter = new ExtensionFilter("TXT files (*.txt)", "*.txt"); 	//http://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
        		ExtensionFilter filterLogo = new ExtensionFilter("LOGO", "*.logo*");
        		fileChooser.getExtensionFilters().addAll(filter, filterLogo);
        		File selectedFile = fileChooser.showOpenDialog(stage);
        		
        		try {
					controller.runFile(selectedFile.getAbsolutePath());
					window.updateUI();
				} catch (InvalidSyntaxException | InvalidCommandException
						| IOException | InvalidParametersException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
            }
             
        });
		
		root.getChildren().add(loadButton);
	}

}
