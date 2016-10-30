package view.ui;
import model.Model;
import view.data.DataIn;
import view.ui.turtle.TurtleScreen;
import controller.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * 
 * The purpose of this class is to display the interface that the user interacts with.
 * 
 * @author Diane Hadley, Pim
 */


public class UI implements UIAttributes{
	
	private HelpWindowUI helpWindowUI;
	private TurtleScreen turtleScreen;
	
	private CommandLine commandLine;
	private Console console;
	private Workspace workspace;
	private Group root = new Group();
	private int xSize, ySize;
	private Stage stage;
	private Model model;
	private LoadCommand loadCommand;
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
		
		buildRoot();
		return scene;
		
	}

	private void buildRoot() {
		helpWindowUI = new HelpWindowUI();
		turtleScreen = new TurtleScreen(stage);	
		root.getChildren().add(turtleScreen.getTurtleSettings().getRoot());		
		generalSettings = new GeneralSettings(controller);
		commandLine = new CommandLine(ySize, this);		
		workspace = new Workspace(xSize,this,commandLine);
		console = new Console(ySize, xSize);
		loadCommand = new LoadCommand(this);
		root.getChildren().addAll(turtleScreen.getRoot(), helpWindowUI.getRoot(),
				generalSettings.getRoot(), commandLine.getRoot(), workspace.getRoot(), 
				console.getRoot(),loadCommand.getRoot());
		makeResetButton();
	}
	
	private void makeResetButton(){
		Button reset = uiBuilder.makeButton(190, 465, uiResources.getString("ResetAll"), "generalcontrol");
		reset.setOnAction((event) -> {
			resetAll();		
		});	
		root.getChildren().add(reset);
	}

	
	private void resetAll() {
		controller.reset();
		model = dataIn.getViewModel();
		turtleScreen.updateTurtles(model.getTurtleMap());
		console.updateConsole(model.getConsoleReturn());
		workspace.updateWorkspace(model.getWorkspace());
		workspace.getRoot();
		console.getRoot();
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
	
	public DataIn getDataIn() {
		return dataIn;
	}
	
		
	public void updateDataIn() throws Exception {	
		dataIn.setCommand(commandLine.getCommand());
		dataIn.setLanguage(generalSettings.getLanguage());
		dataIn.parseCommand(controller);
		model = dataIn.getViewModel();
		turtleScreen.updateTurtles(model.getTurtleMap());
		console.updateConsole(model.getConsoleReturn());
		workspace.updateWorkspace(model.getWorkspace());

		turtleScreen.getRoot();	
	}
	
}