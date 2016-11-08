package view.ui;


import java.util.AbstractMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import view.ui.commands.CommandLine;

/**
 * The purpose of this class is to create the root that visualizes the workspace where
 * users can see the variables that are stored.
 * This root can then be passed to Window to be displayed in the scene
 * 
 * @author Diane Hadley, Pim
 */

public class Workspace implements UIAttributes{
	
	private Group root = new Group();
	private UIBuilder uiBuilder = new UIBuilder();
	private int workspaceX;	
	private VBox VBox;
	private Window window;
	
	private static final int WORKSPACE_Y = 55;
	
	
	public Workspace(int sceneWidth, Window window, CommandLine commandLine){
		super();
		this.window = window;
		this.workspaceX = TURTLE_CANVAS_WIDTH + 160;
		this.VBox=new VBox(20);
		initWorkspace();
	}
	
	
	/**
	 * returns root with all visualization of the workspace
	 * 
	 */	
	public Group getRoot(){
		return root;
	}
	
	
	
	/**
	 * @param variableMap
	 * 
	 * updates the workspace to show all variables the user has stored
	 */
	public void updateWorkspace(AbstractMap<String, Double> variableMap) {
		clearWorkspace();
		for (String varName:variableMap.keySet()) {
			Text varNameText=new Text(varName+" = ");
			Double value=variableMap.get(varName);
			HBox HBox = new HBox(10);
			TextField space = new TextField();
			space.setPrefWidth(50);
			space.setText(""+value);
			HBox.getChildren().addAll(varNameText, space, getSubmitButton(varName,space));
			VBox.getChildren().add(HBox);
		}
	}
	
	private void clearWorkspace() {
		VBox.getChildren().clear();
	}
	
	private void initWorkspace(){
		VBox.setPadding(new Insets(20));
		VBox.setLayoutX(workspaceX);
		VBox.setLayoutY(WORKSPACE_Y);
		root.getChildren().add(VBox);
		root.getChildren().add(
				uiBuilder.getText(workspaceX, WORKSPACE_Y - 10, uiResources.getString("Workspace"))
		);
	}
	
	private Button getSubmitButton(String varName, TextField space) {
		Button button = new Button("Update");
		button.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {  
		    	try {
					window.updateViewData("set :"+varName+" "+space.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    }
		});
		return button;
	}
}