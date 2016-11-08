package view.ui.commands;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import view.data.ViewData;
import view.ui.UIAttributes;
import view.ui.Window;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//This entire file is my code masterpiece - Pim Chuaylua pc131


/**This class is to provide a button to be added to the UI to save the history on command on text file
 * 
 * @author Pim
 *
 */


public class SaveCommand implements UIAttributes {
	private static int BUTTON_X = 480;
	private static int BUTTON_Y = 10;
	private Group root;
	private Button saveButton;
	private ViewData viewData;


	public SaveCommand(ViewData viewData) {
		this.root = new Group();
		this.viewData = viewData;
		initSaveCommandButton();
	}
	
	public Button getRoot() {
		return saveButton;
	}
	
	public void initSaveCommandButton() {
		Stage stage = new Stage();
		stage.setTitle(uiResources.getString("SaveCommand"));
		saveButton = new Button(uiResources.getString("SaveCommand"));
		saveButton.setLayoutX(BUTTON_X);
		saveButton.setLayoutY(BUTTON_Y);
		saveButton.getStyleClass().add("generalcontrol");
		
		saveButton.setOnAction(new EventHandler<ActionEvent>(){
			 
            @Override
            public void handle(ActionEvent arg0) {
            	
            	String commandListString = getCommandListString(viewData.getCommandHistory());
            	
            	FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(stage);
                
                if(file != null){
                    saveFile(commandListString, file);
                }
            }
             
        });
		
		root.getChildren().add(saveButton);
	}
	
	private String getCommandListString(Collection<String> historyList) {
		String commandListString="";
    	for (String each:historyList) {
    		commandListString+=each;
    		commandListString+="\n";
    	}
		return commandListString;
	}
	
	private void saveFile(String content, File file){
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

}
