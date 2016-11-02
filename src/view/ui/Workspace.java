package view.ui;


import java.util.HashMap;
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
 * @author Diane Hadley, Pim
 */

public class Workspace implements UIAttributes{
	
	private Group root = new Group();
	private UIBuilder uiBuilder = new UIBuilder();
	private int workspaceX;
	private int workspaceWidth;
	private int workspaceHeight;
	private TextArea workspace;
	private static int WORKSPACE_Y = 55;
	private VBox VBox;
	private Group group;
	private Window window;
	private CommandLine commandLine;
	
	
	public Workspace(int sceneWidth, Window window, CommandLine commandLine){
		super();
		this.window = window;
		this.workspaceX = TURTLE_CANVAS_WIDTH + 160;
		this.workspaceWidth = sceneWidth - TURTLE_CANVAS_WIDTH - 170;
		this.workspaceHeight = WORKSPACE_HEIGHT;
		this.VBox=new VBox(20);
		this.group=new Group();
		this.commandLine=commandLine;
		makeWorkspace();
	}
	
	
	/*
	 * returns root with all visualization of the workspace
	 * 
	 */	
	public Group getRoot(){
		
		
		return root;
	}
	
	
	private void makeWorkspace(){
		VBox.setPadding(new Insets(20));
		VBox.setLayoutX(workspaceX);
		VBox.setLayoutY(WORKSPACE_Y);
		root.getChildren().add(VBox);
		root.getChildren().add(
				uiBuilder.getText(workspaceX, WORKSPACE_Y - 10, uiResources.getString("Workspace"))
		);
	}
	
	public void updateWorkspace(HashMap<String, Double> variableMap) {
		clearWorkspace();
		for (String varName:variableMap.keySet()) {
			Text varNameText=new Text(varName+" = ");
			Double value=variableMap.get(varName);
			HBox HBox = new HBox(10);
			TextField space = new TextField();
			space.setPrefWidth(50);
			space.setText(""+value);
			HBox.getChildren().addAll(varNameText,space,getSubmitButton(varName,space));
			VBox.getChildren().add(HBox);
		}
	}
	
	public void clearWorkspace() {
		VBox.getChildren().clear();
	}
	
	public Button getSubmitButton(String varName, TextField space) {
		Button button = new Button("Update");
		button.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {  
		    	//commandLine.setCommand("set :"+varName+" "+space.getText());
		    	try {
					window.updateViewData("set :"+varName+" "+space.getText());
					//commandLine.setCommand("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		return button;
	}
}