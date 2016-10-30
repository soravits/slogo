package view.ui;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import view.DisplayError;


/**
 *The purpose of this class is to create the root that visualizes the commandLine
 *and to return the input in the command line as a list of commands so that
 *they can be executed
 *
 * @author Diane Hadley
 *
 */

public class CommandLine implements UIAttributes{
	
	private Group root = new Group();
	private TextArea textArea = new TextArea();
	private DisplayError displayError = new DisplayError();


	private int commandLineHeight;
	private int commandLineWidth;
	private int commandLineY;
	
	private static int FIRST_BUTTON_X = 190;
	private static int BUTTON_SPACING = 170;
	private static int COMMAND_HISTORY_WINDOW_X = 300;
	private static int COMMAND_HISTORY_WINDOW_Y = 300;
	private int buttonsY; 
	
	
	private static int COMMAND_LINE_X = 10;
	private UI ui;
	
	public CommandLine(int sceneHeight, UI ui){
		super();
		this.commandLineHeight = sceneHeight - TURTLE_CANVAS_HEIGHT - 120;
		this.commandLineY = TURTLE_CANVAS_HEIGHT + 110; 
		this.commandLineWidth = COMMAND_LINE_WIDTH;
		this.buttonsY = TURTLE_CANVAS_HEIGHT + 65;
		this.ui = ui;
		makeCommandLine();
		getButtons();
		root.getChildren().add(uiBuilder.getText(COMMAND_LINE_X, commandLineY - 10, 
				uiResources.getString("CommandLine")));
	}
	
	
	/*
	 * returns root with all visualization of commandLine
	 * 
	 */	
	public Group getRoot(){
		
		return root;
	}
	
	
	/*
	 * returns list of objects which are each a line of input in the command line
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
				CommandHistoryWindow commandHistoryWindow = new CommandHistoryWindow(ui,this,COMMAND_HISTORY_WINDOW_X,COMMAND_HISTORY_WINDOW_Y);
				commandHistoryWindow.updateCommandHistory(ui.getModel().getCommandHistory());
				commandHistoryWindow.show();
		});	
		
		Button submit = uiBuilder.makeButton(FIRST_BUTTON_X + BUTTON_SPACING*2, buttonsY, 
				uiResources.getString("Submit"), "generalcontrol");
		submit.setOnAction((event) -> {
			try {
				ui.updateDataIn();
			} catch (Exception e) {
				displayError.displayErrorDialogueBox(uiResources.getString("InvalidCommandError"));
			}
			textArea.setText("");
		});	
		
		root.getChildren().addAll(history, submit);
	}
	
	public void setCommand(String command) {
		textArea.setText(command);
	}
}