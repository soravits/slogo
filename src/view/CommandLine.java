package view;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 *The purpose of this class is to create the root that visualizes the commandLine
 *and to return the input in the command line as a list of commands so that
 *they can be executed
 *
 * @author Diane Hadley
 *
 */



public class CommandLine{
	
	private Group root = new Group();
	private TextArea textArea = new TextArea();
	
	private ResourceBundle commandResources;

	private int commandLineHeight;
	private int commandLineWidth;
	private int commandLineY;
	
	private static int FIRST_BUTTON_X = 190;
	private static int BUTTON_SPACING = 170;
	private int buttonsY; 
	
	private static int COMMAND_LINE_X = 10;
	

	
	public CommandLine(int turtleHeight, int sceneHeight, int commandLineWidth, ResourceBundle resources){
		this.commandLineHeight = sceneHeight - turtleHeight - 120;
		this.commandLineY = turtleHeight + 110; 
		this.commandLineWidth = commandLineWidth;
		this.commandResources = resources;
		this.buttonsY = turtleHeight + 65;
	}
	
	
	/*
	 * returns root with all visualization of commandLine
	 * 
	 */	
	public Group getRoot(){
		makeCommandLine();
		makeButtons();
		getText();
		return root;
	}
	
	
	/*
	 * returns list of objects which are each a line of input in the command line
	 */
	public List<Object> getCommand(){
		return null;
	}
	
	private void makeCommandLine(){
		
		textArea.setLayoutY(commandLineY);
		textArea.setLayoutX(COMMAND_LINE_X);
		textArea.setPrefWidth(commandLineWidth);
		textArea.setPrefHeight(commandLineHeight);
		
		//Make scrollable
		
		root.getChildren().add(textArea);
	}
	
	private void makeButtons(){
		Button reset = new Button(commandResources.getString("ResetAll"));
		Button history = new Button(commandResources.getString("History"));
		Button submit = new Button(commandResources.getString("Submit"));
		root.getChildren().addAll(setControlLayout(reset, 0), 
				setControlLayout(history, 1), setControlLayout(submit, 2));
	}
	
	private void getText(){
		Text commandLine = new Text(commandResources.getString("CommandLine"));
		commandLine.setX(COMMAND_LINE_X);
		commandLine.setY(commandLineY - 10);
		root.getChildren().add(commandLine);		
	}
	
	
	private Control setControlLayout(Control control, int xMultiplier) {
		control.setLayoutX(FIRST_BUTTON_X + BUTTON_SPACING*xMultiplier);
		control.setLayoutY(buttonsY);
		control.setFocusTraversable(false);
		control.getStyleClass().add("generalcontrol");
		return control;
	}
	
	
	
	
}