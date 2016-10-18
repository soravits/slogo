package view;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.control.TextArea;

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

	private int commandLineHeight;
	private int commandLineY;
	
	private static int COMMAND_LINE_WIDTH = 690;
	private static int COMMAND_LINE_X = 10;
	

	
	public CommandLine(int turtleHeight, int sceneHeight){
		this.commandLineHeight = sceneHeight - turtleHeight - 120;
		this.commandLineY = turtleHeight + 110; 
	}
	
	
	/*
	 * returns root with all visualization of commandLine
	 * 
	 */	
	public Group getRoot(){
		makeCommandLine();
		makeControls();
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
		textArea.setPrefWidth(COMMAND_LINE_WIDTH);
		textArea.setPrefHeight(commandLineHeight);
		
		//Make scrollable
		
		root.getChildren().add(textArea);
	}
	
	private void makeControls(){
		
		
	}
	
	
	
	
}