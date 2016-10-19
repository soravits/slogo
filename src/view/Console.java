package view;
import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 * The purpose of this class is to create the root that visualizes the console.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */

public class Console {
	
	private Group root = new Group();
	private int consoleHeight;
	private int consoleWidth;
	private int consoleX;
	private int consoleY;
	private ResourceBundle consoleResources;
	
	
	public Console(int workspaceHeight, int commandLineWidth, int sceneHeight, int sceneWidth, ResourceBundle resources){
		this.consoleHeight = sceneHeight - workspaceHeight - 120;
		this.consoleWidth = sceneWidth - commandLineWidth - 30;
		this.consoleX = commandLineWidth + 20;
		this.consoleY = workspaceHeight + 110;
		this.consoleResources = resources;
	}
	
	
	
	/*
	 * returns root with all visualization of console
	 * 
	 */	
	public Group getRoot(){
		
		makeConsole();
		getText();
		return root;
	}
	
	
	private void makeConsole(){
		TextArea console = new TextArea();
		console.setEditable(false);
		console.setPrefWidth(consoleWidth);
		console.setPrefHeight(consoleHeight);
		console.setLayoutX(consoleX);
		console.setLayoutY(consoleY);
		
		root.getChildren().add(console);
		
	}
	
	private void getText(){
		Text console = new Text(consoleResources.getString("Console"));
		console.setX(consoleX);
		console.setY(consoleY - 10);
		root.getChildren().add(console);	
	}
	
}

