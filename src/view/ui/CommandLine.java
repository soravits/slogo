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
 * @author Diane Hadley, Pim Chuaylua
 *
 */

//This entire file is my masterpiece. - Pim Chuaylua pc131

public class CommandLine implements UIAttributes{
	
	private Group root;
	private TextArea textArea;
	private DisplayError displayError;
	private UIBuilder uiBuilder;

	private static final int COMMAND_LINE_HEIGHT = 540 - TURTLE_CANVAS_HEIGHT;
	private static final int FIRST_BUTTON_X = 190;
	private static final int FIRST_BUTTON_Y = TURTLE_CANVAS_HEIGHT + 65;
	private static final int BUTTON_SPACING = 170;
	private static final int COMMAND_LINE_X = 10;
	private static final int COMMAND_LINE_Y = TURTLE_CANVAS_HEIGHT + 110;
	
	private Window window;
	
	public CommandLine(int sceneHeight, Window window){
		super();
		this.root = new Group();
		this.textArea = new TextArea();
		this.displayError = new DisplayError();
		this.uiBuilder = new UIBuilder();
		this.window = window;
		initCommandLineSpace();
		initButtons();
		root.getChildren().add(uiBuilder.getText(COMMAND_LINE_X, COMMAND_LINE_Y - 10, 
				uiResources.getString("CommandLine")));
	}
	
	public Group getRoot(){
		
		return root;
	}

	public String getCommand(){
		return textArea.getText();
	}
	
	private void initCommandLineSpace(){
		textArea.setLayoutY(COMMAND_LINE_Y);
		textArea.setLayoutX(COMMAND_LINE_X);
		textArea.setPrefWidth(COMMAND_LINE_WIDTH);
		textArea.setPrefHeight(COMMAND_LINE_HEIGHT);
		root.getChildren().add(textArea);
	}
	
	private void initButtons(){

		Button history = uiBuilder.makeButton(FIRST_BUTTON_X + BUTTON_SPACING, FIRST_BUTTON_Y, 
				uiResources.getString("History"), "generalcontrol");
		history.setOnAction((event) -> {
				CommandHistoryWindow commandHistoryWindow = new CommandHistoryWindow(window);
				commandHistoryWindow.updateCommandHistory(window.getViewData().getCommandHistory());
				commandHistoryWindow.show();
		});	
		
		Button submit = uiBuilder.makeButton(FIRST_BUTTON_X + BUTTON_SPACING*2, FIRST_BUTTON_Y, 
				uiResources.getString("Submit"), "generalcontrol");
		
		submit.setOnAction((event) -> {
			try {
				window.updateViewData(this.getCommand());
				window.updateUI();
			} catch (Exception e) {
				displayError.displayErrorDialogueBox(e.getMessage());
			}
			
			textArea.setText("");
		});	
		
		root.getChildren().addAll(history, submit);
	}
	
}