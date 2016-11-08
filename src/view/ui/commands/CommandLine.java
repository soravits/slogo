package view.ui.commands;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import view.DisplayError;
import view.ui.UIAttributes;
import view.ui.UIBuilder;
import view.ui.Window;


/**
 *The purpose of this class is to create the root that visualizes the commandLine
 *and to return the input in the command line as a string so that
 *they can be executed
 *
 * @author Diane Hadley
 *
 */

public class CommandLine implements UIAttributes{
	
	private Group root = new Group();
	private TextArea textArea = new TextArea();
	private DisplayError displayError = new DisplayError();
	private UIBuilder uiBuilder = new UIBuilder();

	private int commandLineHeight;
	private int commandLineWidth;
	private int commandLineY;
	private int buttonsY; 
	
	private static final int FIRST_BUTTON_X = 190;
	private static final int BUTTON_SPACING = 170;
	private static final int COMMAND_HISTORY_WINDOW_Y = 600;
	private static final int COMMAND_HISTORY_WINDOW_X = 300;
	private static final int COMMAND_LINE_X = 10;
	
	private Window window;
	
	
	/**
	 * Instantiates CommandLine by determining the size and location of the command line,
	 * creating the text area that is the command line, 
	 */
	public CommandLine(int sceneHeight, Window window){
		super();
		this.commandLineHeight = sceneHeight - TURTLE_CANVAS_HEIGHT - 145;
		this.commandLineY = TURTLE_CANVAS_HEIGHT + 110; 
		this.commandLineWidth = COMMAND_LINE_WIDTH;
		this.buttonsY = TURTLE_CANVAS_HEIGHT + 65;
		this.window = window;
		makeCommandLine();
		getButtons();
		root.getChildren().add(uiBuilder.getText(COMMAND_LINE_X, commandLineY - 10, 
				uiResources.getString("CommandLine")));
	}
	
	
	/**
	 * returns root with all visualization of commandLine
	 * 
	 */	
	public Group getRoot(){	
		return root;
	}
	
	
	/**
	 * returns user input in the command line text area 
	 * as a string
	 */

	public String getCommand(){
		return textArea.getText();
	}
	
	private void makeCommandLine(){
		
		textArea.setLayoutY(commandLineY);
		textArea.setLayoutX(COMMAND_LINE_X);
		textArea.setPrefWidth(commandLineWidth);
		textArea.setPrefHeight(commandLineHeight);
		root.getChildren().add(textArea);
	}
	
	private void getButtons(){

		Button history = uiBuilder.makeButton(FIRST_BUTTON_X + BUTTON_SPACING, buttonsY, 
				uiResources.getString("History"), "generalcontrol");
		history.setOnAction((event) -> {
				showCommandHistory();
		});			
		Button submit = uiBuilder.makeButton(FIRST_BUTTON_X + BUTTON_SPACING*2, buttonsY, 
				uiResources.getString("Submit"), "generalcontrol");
		submit.setOnAction((event) -> {
			submitCommandToModel();
			textArea.setText("");
		});	
		
		root.getChildren().addAll(history, submit);
	}


	private void showCommandHistory() {
		CommandHistoryWindow commandHistoryWindow = new CommandHistoryWindow(window,this,COMMAND_HISTORY_WINDOW_Y,COMMAND_HISTORY_WINDOW_X);
		commandHistoryWindow.updateCommandHistory(window.getViewData().getCommandHistory());
		commandHistoryWindow.show();
	}


	private void submitCommandToModel() {
		try {
			window.updateViewData(this.getCommand());
			window.updateUI();
		} catch (Exception e) {
			displayError.displayErrorDialogueBox(e.getMessage());
		}
	}
	
	public void setCommand(String command) {
		textArea.setText(command);
	}
}