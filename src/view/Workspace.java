package view;
import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 * The purpose of this class is to create the root that visualizes the workspace.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */


public class Workspace{
	
	private Group root = new Group();
	private int workspaceX;
	private int workspaceWidth;
	private int workspaceHeight;
	private ResourceBundle workspaceResources;
	
	private static int WORKSPACE_Y = 55;
	
	
	public Workspace(int turtleWidth, int workspaceHeight, int sceneWidth, ResourceBundle resources){
		this.workspaceX = turtleWidth + 160;
		this.workspaceWidth = sceneWidth - turtleWidth - 170;
		this.workspaceHeight = workspaceHeight; 
		this.workspaceResources = resources;
	
		
		
	}
	
	
	/*
	 * returns root with all visualization of the workspace
	 * 
	 */	
	public Group getRoot(){
		makeWorkspace();
		getText();
		return root;
	}
	
	
	private void makeWorkspace(){
		TextArea workspace = new TextArea();
		workspace.setLayoutX(workspaceX);
		workspace.setLayoutY(WORKSPACE_Y);
		
		workspace.setPrefWidth(workspaceWidth);
		workspace.setPrefHeight(workspaceHeight);
		
		root.getChildren().add(workspace);
	}
	
	
	private void getText(){
		Text workspace = new Text(workspaceResources.getString("Workspace"));
		workspace.setX(workspaceX);
		workspace.setY(WORKSPACE_Y - 10);
		root.getChildren().add(workspace);	
	}
	
}