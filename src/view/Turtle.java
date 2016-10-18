package view;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

/**
 * The purpose of this class is to create the root that visualizes the turtle.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */


public class Turtle{
	
	private Pane root = new Pane();
	private TurtleSettings turtleSettings;
	
	private static int TURTLE_X = 10;
	private static int TURTLE_Y = 55;
	private int canvasWidth;
	private int canvasHeight;
	
	
	/*
	 * initiates Turtle and sets instance of TurtleSettings
	 */
	
	public Turtle(TurtleSettings settings, int turtleWidth, int turtleHeight){
		this.turtleSettings = settings;
		this.canvasWidth = turtleWidth;
		this.canvasHeight = turtleHeight;		
		makeCanvas();
	}
	
	
	/*
	 * returns root with all visualization of turtle
	 * 
	 */	
	public Pane getRoot(){
		setCanvas();
		return root;
	}
	
	private void makeCanvas(){		
		Canvas turtleCanvas = new Canvas(canvasWidth, canvasHeight);
		root.setLayoutX(TURTLE_X);
		root.setLayoutY(TURTLE_Y);
		GraphicsContext turtleView = turtleCanvas.getGraphicsContext2D();	
		root.getChildren().add(turtleCanvas);		
	}
	
	
	private void setCanvas(){
		Paint color = turtleSettings.getBackgroundColor();		
		BackgroundFill backgroundColor = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(backgroundColor);	
		root.setBackground(background);
	}
	
}