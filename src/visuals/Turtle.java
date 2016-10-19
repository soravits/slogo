package visuals;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * The purpose of this class is to create the root that visualizes the turtle.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */


public class Turtle{
	
	Pane root = new Pane();
	
	private static int TURTLE_X = 10;
	private static int TURTLE_Y = 60;
	private static int CANVAS_WIDTH = 550;
	private static int CANVAS_HEIGHT = 400;
	
	/*
	 * returns root with all visualization of turtle
	 * 
	 */	
	public Pane getRoot(){
		makeCanvas();
		return root;
	}
	
	public void makeCanvas(){
		
		Canvas turtleCanvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);

		root.setLayoutX(TURTLE_X);
		root.setLayoutY(TURTLE_Y);
		
		BackgroundFill backgroundColor = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(backgroundColor);	
		root.setBackground(background);
		
		GraphicsContext turtleView = turtleCanvas.getGraphicsContext2D();
		

		
		
		root.getChildren().add(turtleCanvas);		
	}
	
}