package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ui.UI;

/**
 * @author Diane Hadley
 * The purpose of this class is to start the entire application
 * up, set the stage and scene, and show it.
 */

public class Main extends Application {
	private UI ui;
	public static int XSIZE = 1000;
	public static int YSIZE = 700;
	public static String TITLE = "SLogo";
	public static String COMBO_BOX_WORKAROUND = "glass.accessible.force";
	public static String FALSE = "glass.accessible.force";

	/** 
	 * sets up visualization window
	 */
	public void start(Stage stage) {
		System.setProperty(COMBO_BOX_WORKAROUND, FALSE);
		ui = new UI(XSIZE, YSIZE, stage);
		stage.setTitle(TITLE);
		stage.setScene(ui.init());
		stage.setResizable(false);
		stage.show();
	}
	
	/**
	 * launches project
	 * @param args
	 */
	public static void main(String[] args){
		launch(args);
	}
}