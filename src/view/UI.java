package view;
import model.Model;
import view.data.DataIn;
import controller.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * 
 * The purpose of this class is to display the interface that the user interacts with.
 * 
 * @author Diane Hadley
 */


public class UI {
	
	private HelpWindowUI helpWindowUI;
	private Turtle turtle;
	
	private CommandLine commandLine;
	private Console console;
	private Workspace workspace;
	private Group root = new Group();
	private int xSize, ySize;
	private Stage stage;
	private Model model;
	
	public GeneralSettings generalSettings;
	public DataIn dataIn;
	public Controller controller;
	
	
	
	private static final String CSS_FILE_NAME = "resources/UIStyling.css";
	
	/**
	 * constructor to set the size of the window and set the resource bundle to use
	 */
	public UI(int xSize, int ySize, Stage stage) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.stage = stage;
	}

	
	
	
	/**
	 * Creates a root and initiates the scene. Main calls this method to start the program.
	 */
	public Scene init(){
				
		Scene scene = new Scene(root, xSize, ySize, Color.LIGHTGRAY);
		scene.getStylesheets().add(CSS_FILE_NAME);
		

		model = new Model();
		dataIn = new DataIn(model);
		controller = new Controller(dataIn);
		

		helpWindowUI = new HelpWindowUI();
		
		//turtleSettings = new TurtleSettings(this, stage);
		
		//root.getChildren().add(turtleSettings.getRoot());		
		
		//turtle = new Turtle(stage. model);	
		
		turtle = new Turtle(stage);
		
		root.getChildren().add(turtle.getTurtleSettings().getRoot());
		
		generalSettings = new GeneralSettings();
		

		commandLine = new CommandLine(ySize, this);
		
		workspace = new Workspace(xSize);
	
		console = new Console(ySize, xSize);
		
		root.getChildren().addAll(turtle.getRoot(), helpWindowUI.getRoot(),
				generalSettings.getRoot(), commandLine.getRoot(), workspace.getRoot(), 
				console.getRoot());
		return scene;
		
	}
	
	public GeneralSettings getGeneralSettings(){
		return generalSettings;
	}
	
	public Controller getController() {
		return controller;
	}
	
	public Model getModel() {
		return model;
	}
	
	
	public void updateDataIn() throws Exception {	
		
		dataIn.setCommand(commandLine.getCommand());
		dataIn.setLanguage(generalSettings.getLanguage());
		dataIn.parseCommand(controller);
		
		model = dataIn.getViewModel();
		
		turtle.updateTurtle(model.getTurtleMap());
		//console.updateConsole(model.);
		workspace.updateWorkspace(model.getWorkspace());
		System.out.println(model.getCommandHistory());
		turtle.getRoot();
		
	}
	
}