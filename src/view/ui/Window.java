package view.ui;

import java.util.Observable;
import java.util.Observer;
import controller.Controller;
import javafx.scene.Group;
import javafx.stage.Stage;
import view.data.ViewData;
import view.ui.commands.CommandLine;
import view.ui.commands.LoadCommand;
import view.ui.commands.SaveCommand;
import view.ui.turtle.TurtleScreen;

/**
 * The purpose of this class is to build the root that fills the scene the user
 * sees and to update both the user interface and the class ViewData
 * 
 * @author Diane Hadley
 * 
 */


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
	
	/**
	 * returns root with all elements of the ui that a user will see
	 * for one workspace/tab
	 */
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
	
	/**
	 *returns an instance of ViewData
	 */
	public ViewData getViewData() {
		return viewData;
	}
	
	/**
	 * calls a method in ViewData that will process the command
	 * upon receiving a string of the command and an instance of the controller
	 * 
	 */
	public void updateViewData(String command) throws Exception {	
		viewData.sendCommand(command,controller);
	}
	
	/**
	 * calls all methods that update the user interface
	 */
	public void updateUI() {
		turtleScreen.updateTurtles();
		console.updateConsole(viewData.getConsoleReturn());
		workspace.updateWorkspace(viewData.getWorkspace());
		turtleScreen.getRoot();	
	}

	/**
	 * calls updateUI()
	 */
    @Override
    public void update (Observable o, Object arg) {
        updateUI();        
    }
	

        
        
}