package view.ui;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import view.data.ViewData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import controller.Controller;

public class SaveCommand implements UIAttributes {
	private static int BUTTON_X = 480;
	private static int BUTTON_Y = 10;
	private Group root;
	private Button saveButton;
	private Window window;
	private Controller controller;
	private ViewData viewData;
	
	SaveCommand(Window window) {
		this.root = new Group();
		this.window = window;
		this.viewData = window.getViewData();
		makeButton();
	}
	
	public Button getRoot() {
		return saveButton;
	}
	
	public void makeButton() {
		Stage stage = new Stage();
		stage.setTitle("java-buddy.blogspot.com");
		saveButton = new Button(uiResources.getString("SaveCommand"));
		saveButton.setLayoutX(BUTTON_X);
		saveButton.setLayoutY(BUTTON_Y);
		saveButton.getStyleClass().add("generalcontrol");
		
		saveButton.setOnAction(new EventHandler<ActionEvent>(){
			 
            @Override
            public void handle(ActionEvent arg0) {
            	Collection<String> historyList = viewData.getCommandHistory();
            	
            	//testing
            	/*ArrayList<String> historyList = new ArrayList<String>();
            	historyList.add("set pim 30");
            	historyList.add("set diane 20");
            	historyList.add("fd 100");*/
            	
            	String commandListString="";
            	for (String each:historyList) {
            		commandListString+=each;
            		commandListString+="\n";
            	}
            	
            	FileChooser fileChooser = new FileChooser();
            	  
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                
                //Show save file dialog
                File file = fileChooser.showSaveDialog(stage);
                
                if(file != null){
                    SaveFile(commandListString, file);
                }
            }
             
        });
		
		root.getChildren().add(saveButton);
	}
	
	private void SaveFile(String content, File file){
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
