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

/**
 * The purpose of this class is to create the root that visualizes the workspace where
 * users can see the variables that are stored.
 * This root can then be passed to Window to be displayed in the scene
 * 
 * @author Diane Hadley, Pim Chuaylua
 */

//This entire file is my code masterpiece - Pim Chuaylua pc131

public class Workspace implements UIAttributes{
	
	private Group root;
	private UIBuilder uiBuilder;
	private VBox vbox;
	private Window window;
	
	private static final int WORKSPACE_X = TURTLE_CANVAS_WIDTH + 160;
	private static final int WORKSPACE_Y = 55;
	private static final int SPACE_WIDTH = 50;
	private static final int HBOX_WIDTH = 10;
	public static final int VBOX_PADDING = 20;
	public static final int HBOX_PADDING = 10;
	
	public Workspace(Window window){
		super();
		this.root = new Group();
		this.uiBuilder = new UIBuilder();
		this.window = window;
		this.vbox=new VBox(VBOX_PADDING);
		initWorkspace();
	}
	

	public Group getRoot(){
		return root;
	}
	
	/**
	 * updates the workspace to show all variables the user has stored
	 */

	private void initWorkspace(){
		vbox.setPadding(new Insets(VBOX_PADDING));
		vbox.setLayoutX(WORKSPACE_X);
		vbox.setLayoutY(WORKSPACE_Y);
		root.getChildren().add(vbox);
		root.getChildren().add(
				uiBuilder.getText(WORKSPACE_X, WORKSPACE_Y - 10, uiResources.getString("Workspace"))
		);
	}
	
	private void clearWorkspace() {
		vbox.getChildren().clear();
	}
	
	private Button getSubmitButton(String varName, TextField space) {
		Button button = new Button("Update");
		button.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {  
		    	try {
					window.updateViewData("set " + varName + " " + space.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    }
		});
		
		return button;
	}
	
	public void updateWorkspace(AbstractMap<String, Double> variableMap) {
		
		clearWorkspace();
		
		for (String varName:variableMap.keySet()) {
			
			Text varNameText = new Text(varName+" = ");
			Double value = variableMap.get(varName);
			
			
			TextField space = new TextField();
			space.setPrefWidth(SPACE_WIDTH);
			space.setText(""+value);
			
			HBox hbox = new HBox(HBOX_WIDTH);
			hbox.getChildren().addAll(varNameText, space, getSubmitButton(varName,space));
			
			vbox.getChildren().add(hbox);
		}
	}
}