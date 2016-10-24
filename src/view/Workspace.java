package view;
import view.data.DataIn;

import java.util.HashMap;
import java.util.Queue;

import model.WorkspaceState;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


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
	private VBox VBox;
	private Group group;
	
	
	public Workspace(int sceneWidth){
		super();
		
		this.workspaceX = TURTLE_CANVAS_WIDTH + 160;
		this.workspaceWidth = sceneWidth - TURTLE_CANVAS_WIDTH - 170;
		this.workspaceHeight = WORKSPACE_HEIGHT;
		this.VBox=new VBox(20);
		this.group=new Group();
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
		VBox.setPadding(new Insets(20));
		VBox.setLayoutX(workspaceX);
		VBox.setLayoutY(WORKSPACE_Y);
		/*workspace = new TextArea();
		workspace.setLayoutX(workspaceX);
		workspace.setLayoutY(WORKSPACE_Y);
		workspace.setPrefWidth(workspaceWidth);
		workspace.setPrefHeight(workspaceHeight);
		group.getChildren().add(VBox);
		root.getChildren().add(workspace);*/
		root.getChildren().add(VBox);
	}
	
	public void updateWorkspace(WorkspaceState workspaceState) {
		//HashMap<String, Double> variableMap = workspaceState.getListOfVariables();
		HashMap<String, Double> variableMap = new HashMap<String, Double>();
		variableMap.put("x",2.0);
		variableMap.put("y",3.0);
		variableMap.put("z",3.0);
		variableMap.put("pim",100.0);
		for (String varName:variableMap.keySet()) {
			Text varNameText=new Text(varName+" = ");
			Double value=variableMap.get(varName);
			HBox HBox = new HBox(10);
			TextField space = new TextField();
			space.setPrefWidth(50);
			space.setText(""+value);
			HBox.getChildren().addAll(varNameText,space,getSubmitButton(varName,value));
			VBox.getChildren().add(HBox);
		}
		
		
	}
	
	public void clearWorkspace() {
		root.getChildren().clear();
	}
	
	public Button getSubmitButton(String command, Double value) {
		Button button = new Button("Update");
		button.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {  
		    	//
		    }
		});
		return button;
	}
	
	
	
}