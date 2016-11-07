package view.ui;

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author Diane Hadley
 * 
 */


import controller.Controller;
import javafx.scene.Group;
import javafx.stage.Stage;
import view.data.ViewData;
import view.ui.turtle.TurtleScreen;

public class Window implements UIAttributes, Observer{
	
	private HelpWindowUI helpWindowUI;
	private TurtleScreen turtleScreen;
	private GeneralSettings generalSettings;
	private CommandLine commandLine;
	private Console console;
	private Workspace workspace;
	private Stage stage;
	private LoadCommand loadCommand;
	private SaveCommand saveCommand;
	private ViewData viewData;
	private Controller controller;
	
	private int xSize, ySize;
	
	private Group root = new Group();

	public Window(Stage stage, int xSize, int ySize){
		this.stage = stage;
		this.xSize = xSize;
		this.ySize = ySize;	
		this.viewData = new ViewData();
		this.controller = new Controller(viewData);
		controller.addObserver(this);
		buildRoot();
	}
	
	
	public Group getRoot(){		
		return root;
	}

	private void buildRoot() {
		helpWindowUI = new HelpWindowUI();
		turtleScreen = new TurtleScreen(stage, viewData, controller);	
		root.getChildren().add(turtleScreen.getTurtleSettings().getRoot());	
		
		generalSettings = new GeneralSettings(controller);
		commandLine = new CommandLine(ySize, this);		
		workspace = new Workspace(this);
		console = new Console(ySize, xSize);
		loadCommand = new LoadCommand(this);
		saveCommand = new SaveCommand(viewData);
		
		root.getChildren().addAll(turtleScreen.getRoot(), helpWindowUI.getRoot(),
				generalSettings.getRoot(), commandLine.getRoot(), workspace.getRoot(), 
				console.getRoot(),loadCommand.getRoot(),saveCommand.getRoot());

	}
	

	public GeneralSettings getGeneralSettings(){
		return generalSettings;
	}
	
	public Controller getController() {
		return controller;
	}
	
	public ViewData getViewData() {
		return viewData;
	}
	
		
	public void updateViewData(String command) throws Exception {	
		viewData.sendCommand(command,controller);
	}
	
	public void updateUI() {
		turtleScreen.updateTurtles();
		console.updateConsole(viewData.getConsoleReturn());
		workspace.updateWorkspace(viewData.getWorkspace());
		turtleScreen.getRoot();	
	}


    @Override
    public void update (Observable o, Object arg) {
        updateUI();        
    }

	
 
        
        
}