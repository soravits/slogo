package view.ui;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Model;
import view.data.DataIn;
import view.ui.turtle.TurtleScreen;

public class Window implements UIAttributes{
	
	private UIBuilder uiBuilder = new UIBuilder();
	private HelpWindowUI helpWindowUI;
	private TurtleScreen turtleScreen;
	private GeneralSettings generalSettings;
	private CommandLine commandLine;
	private Console console;
	private Workspace workspace;
	private Stage stage;
	private LoadCommand loadCommand;
	
	private Model model;
	private DataIn dataIn;
	private Controller controller;
	
	private int xSize, ySize;
	
	private Group root = new Group();
	
	
	public Window(Stage stage, int xSize, int ySize){
		this.stage = stage;
		this.xSize = xSize;
		this.ySize = ySize;	
		model = new Model();
		dataIn = new DataIn(model);
		controller = new Controller(dataIn);
		buildRoot();
	}
	
	
	public Group getRoot(){
		
		return root;
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

//		makeResetButton();
	}
	
//	private void makeResetButton(){
//		Button reset = uiBuilder.makeButton(190, 515, uiResources.getString("ResetAll"), "generalcontrol");
//		reset.setOnAction((event) -> {
//			resetAll();		
//		});	
//		root.getChildren().add(reset);
//	}

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
	}
	
	public void updateUI() {
		model = dataIn.getViewModel();
		turtleScreen.updateTurtles(model.getTurtleMap());
		console.updateConsole(model.getConsoleReturn());
		workspace.updateWorkspace(model.getWorkspace());
		turtleScreen.getRoot();	
	}
	
	
}