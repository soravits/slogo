package view.ui;

import java.util.ResourceBundle;

public interface UIAttributes{
	
	public static final int TURTLE_CANVAS_HEIGHT = 450;
	public static final int TURTLE_CANVAS_WIDTH = 620;
	public static final int WORKSPACE_HEIGHT = 400;
	public static final int COMMAND_LINE_WIDTH = 670;
	
	
	public static final String RESOURCE_FILE_NAME = "resources/DisplayedText";
	
	public static final ResourceBundle uiResources = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	
	
}