package view;
import controller.Controller;
import javafx.scene.Group;
import view.data.DataIn;
import view.data.DataOut;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import view.data.DataIn;
import view.data.DataOut;

/**
 *The purpose of this class is to create the root that visualizes the commandLine
 *and to return the input in the command line as a list of commands so that
 *they can be executed
 *
 * @author Diane Hadley
 *
 */



public class CommandLine extends UIBuilder{
	
	private Group root = new Group();
	private TextArea textArea = new TextArea();

	private int commandLineHeight;
	private int commandLineWidth;
	private int commandLineY;
	
	private static int FIRST_BUTTON_X = 190;
	private static int BUTTON_SPACING = 170;
	private int buttonsY; 
	
	private static int COMMAND_LINE_X = 10;
	
	private DataIn DataIn;
	private DataOut DataOut;
	
	public CommandLine(int sceneHeight,DataIn DataIn,DataOut DataOut){
		super();
		this.commandLineHeight = sceneHeight - TURTLE_CANVAS_HEIGHT - 120;
		this.commandLineY = TURTLE_CANVAS_HEIGHT + 110; 
		this.commandLineWidth = COMMAND_LINE_WIDTH;
		this.buttonsY = TURTLE_CANVAS_HEIGHT + 65;
		this.DataIn=DataIn;
		this.DataOut=DataOut;
	}
	
	
	/*
	 * returns root with all visualization of commandLine
	 * 
	 */	
	public Group getRoot(){
		makeCommandLine();
		getButtons();
		root.getChildren().add(getText(COMMAND_LINE_X, commandLineY - 10, 
				uiResources.getString("CommandLine")));
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
		Button reset = makeButton(FIRST_BUTTON_X, buttonsY, uiResources.getString("ResetAll"), "generalcontrol");
		reset.setOnAction((event) -> {
			//TODO: add action
		});	
		
		Button history = makeButton(FIRST_BUTTON_X + BUTTON_SPACING, buttonsY, 
				uiResources.getString("History"), "generalcontrol");
		history.setOnAction((event) -> {
			displayCommandHistory();
		});	
		
		Button submit = makeButton(FIRST_BUTTON_X + BUTTON_SPACING*2, buttonsY, 
				uiResources.getString("Submit"), "generalcontrol");
		submit.setOnAction((event) -> {
			try {
				updateDataIn();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayDataOut();
			textArea.setText("");
		});	
		
		root.getChildren().addAll(reset, history, submit);
	}
	
	private void updateDataIn() throws Exception {
		DataIn.setCommand(textArea.getText());
		DataIn.setLanguage(UI.generalSettings.getLanguage());
		//testing
//		System.out.println(DataIn.getCommand());
//		System.out.println(DataIn.getLanguage());
		DataIn.parseCommand(UI.Controller);
	}
	
	private void displayDataOut() {
		if (!commandIsEmpty()) {
			UI.console.displayResults();
			UI.workspace.displayResults();
		}
	}
	
	private void displayCommandHistory() {
		CommandHistoryWindow CommandHistoryWindow=new CommandHistoryWindow(100,100,DataOut);
		CommandHistoryWindow.displayHistory();
	}
	
	private boolean commandIsEmpty() {
		return textArea.getText().trim().equals("");
	}
	

	
}