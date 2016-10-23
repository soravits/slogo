package view;

import java.util.HashMap;
import java.util.Queue;

import javafx.scene.Group;
import javafx.scene.control.TextArea;


/**
 * The purpose of this class is to create the root that visualizes the workspace.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */


public class Workspace extends UIBuilder{
	
	private Group root = new Group();
	private int workspaceX;
	private int workspaceWidth;
	private int workspaceHeight;
	private TextArea workspace;
	private static int WORKSPACE_Y = 55;
	private DataOut DataOut;
	
	
	public Workspace(int sceneWidth, DataOut DataOut){
		super();
		
		this.workspaceX = TURTLE_CANVAS_WIDTH + 160;
		this.workspaceWidth = sceneWidth - TURTLE_CANVAS_WIDTH - 170;
		this.workspaceHeight = WORKSPACE_HEIGHT;
		this.DataOut=DataOut;
	}
	
	
	/*
	 * returns root with all visualization of the workspace
	 * 
	 */	
	public Group getRoot(){
		makeWorkspace();
		root.getChildren().add(
				getText(workspaceX, WORKSPACE_Y - 10, uiResources.getString("Workspace"))
		);
		return root;
	}
	
	
	private void makeWorkspace(){
		workspace = new TextArea();
		workspace.setLayoutX(workspaceX);
		workspace.setLayoutY(WORKSPACE_Y);
		
		workspace.setPrefWidth(workspaceWidth);
		workspace.setPrefHeight(workspaceHeight);
		
		root.getChildren().add(workspace);
	}
	
	//testing
		public void displayResults() {
			HashMap<String,Double> results= DataOut.getVariables();
			for (String key:results.keySet()) {
				workspace.appendText(key+": "+results.get(key)+"\n");
			}
		}
	
}