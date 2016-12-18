package view.ui;
import java.util.Collection;
import javafx.scene.Group;
import javafx.scene.control.TextArea;


/**
 * The purpose of this class is to create the root that visualizes the console.
 * This root can then be passed to Window to be displayed in the scene
 * 
 * @author Diane Hadley, Pim Chuaylua
 */



public class Console implements UIAttributes{
	
	private Group root;
	private UIBuilder uiBuilder;
	private int consoleHeight;
	private int consoleWidth;
	private int consoleX;
	private int consoleY;
	private TextArea console;
	
	public Console(int sceneHeight, int sceneWidth){
		super();
		this.root = new Group();
		this.uiBuilder = new UIBuilder();
		this.consoleHeight = sceneHeight - WORKSPACE_HEIGHT - 145;
		this.consoleWidth = sceneWidth - COMMAND_LINE_WIDTH - 30;
		this.consoleX = COMMAND_LINE_WIDTH + 20;
		this.consoleY = WORKSPACE_HEIGHT + 110;
	}
	
	
	/**
	 * returns root with all visualization of console
	 * 
	 */	

	public Group getRoot(){		
		initConsole();
		root.getChildren().add(uiBuilder.getText(consoleX, consoleY - 10, uiResources.getString("Console")));
		return root;
	}
	
	/**
	 * @param consoleResults
	 * Updates console to display results of command
	 */
	public void updateConsole(Collection<String> consoleResults) {
		for (String command:consoleResults) {
			console.appendText(command+"\n");
		}
	}
	
	private void initConsole(){
		console = new TextArea();
		console.setEditable(false);
		console.setPrefWidth(consoleWidth);
		console.setPrefHeight(consoleHeight);
		console.setLayoutX(consoleX);
		console.setLayoutY(consoleY);		
		root.getChildren().add(console);
	}
	
	
}

