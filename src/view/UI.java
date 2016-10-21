package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 * 
 * The purpose of this class is to display the interface that the user interacts with.
 * 
 * @author Diane Hadley
 */


public class UI {
	
	private HelpWindowUI helpWindowUI;
	private Turtle turtle;
	private TurtleSettings turtleSettings;
	private GeneralSettings generalSettings;
	private CommandLine commandLine;
	private Workspace workspace;
	private Group root = new Group();
	private int xSize, ySize;
	
	public static DataIn DataIn;
	public static DataOut DataOut;
	public static Console console;
	
	private static final String CSS_FILE_NAME = "resources/UIStyling.css";
	
	/**
	 * constructor to set the size of the window and set the resource bundle to use
	 */
	public UI(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
	}

	
	/**
	 * Creates a root and initiates the scene. Main calls this method to start the program.
	 */
	public Scene init(){
				
		Scene scene = new Scene(root, xSize, ySize, Color.LIGHTGRAY);
		scene.getStylesheets().add(CSS_FILE_NAME);
		
		DataIn=new DataIn();
		DataOut=new DataOut();
		
		
		helpWindowUI = new HelpWindowUI();
		
		turtleSettings = new TurtleSettings(this);
		
		root.getChildren().add(turtleSettings.getRoot());		
		
		turtle = new Turtle(turtleSettings);	
		
		generalSettings = new GeneralSettings();
		
		commandLine = new CommandLine(ySize,DataIn);
		
		workspace = new Workspace(xSize);
	
		console = new Console(ySize, xSize,DataOut);
		
		root.getChildren().addAll(turtle.getRoot(), helpWindowUI.getRoot(),
				generalSettings.getRoot(), commandLine.getRoot(), workspace.getRoot(), 
				console.getRoot());
		return scene;
		
	}
	
	public void addTurtleToRoot(){
		turtle.getRoot();
	}
	
	
}