package view.ui;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import controller.Controller;

public class SaveCommand implements UIAttributes {
	private static int BUTTON_X = 480;
	private static int BUTTON_Y = 10;
	private Group root;
	private Button saveButton;
	private Stage stage;
	private Window window;
	private Controller controller;
	
	SaveCommand(Window window) {
		this.root = new Group();
		this.stage = new Stage();
		this.window = window;
		this.controller = window.getController();
		makeButton();
	}
	
	public Button getRoot() {
		return saveButton;
	}
	
	public void makeButton() {
		saveButton = new Button(uiResources.getString("SaveCommand"));
		saveButton.setLayoutX(BUTTON_X);
		saveButton.setLayoutY(BUTTON_Y);
		saveButton.getStyleClass().add("generalcontrol");
		
		saveButton.setOnAction(new EventHandler<ActionEvent>(){
			 
            @Override
            public void handle(ActionEvent arg0) {
            	//
        		
            }
             
        });
		
		root.getChildren().add(saveButton);
	}

}
