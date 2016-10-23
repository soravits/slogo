package view;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


/**
 * The purpose of this class is to create the root that visualizes the turtle.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */


public class Turtle extends UIBuilder{
	
	private Pane root = new Pane();
	private TurtleSettings turtleSettings;
	private GraphicsContext turtleView;
	private Image turtleImage;
	
	private static int TURTLE_X = 10;
	private static int TURTLE_Y = 55;
	private static int TURTLE_SIZE = 30;
	private int canvasWidth;
	private int canvasHeight;
	private double originX;
	private double originY;
	private double currX;
	private double currY;
	
	
	
	/*
	 * initiates Turtle and sets instance of TurtleSettings
	 */
	
	public Turtle(Stage stage){
		super();
		this.turtleSettings = new TurtleSettings(stage, this);
		//root.getChildren().add(turtleSettings.getRoot());
		this.canvasWidth = TURTLE_CANVAS_WIDTH;
		this.canvasHeight = TURTLE_CANVAS_HEIGHT;	
		this.originX = canvasWidth/2;
		this.originY = canvasHeight/2;
		this.currX = originX;
		this.currY = originY;
		bindInstanceVariables();
		makeCanvas();
	}
	
	
	/*
	 * returns root with all visualization of turtle
	 * 
	 */	
	public Pane getRoot(){
		
		setCanvas();
		setTurtle();
		
		return root;
	}
	
	public TurtleSettings getTurtleSettings(){
		return turtleSettings;
	}
	
	private void bindInstanceVariables(){
		//TODO: bind currX and currY to turtle coordinates from model
	}
	
	
	private void makeCanvas(){		
		
		Canvas turtleCanvas = new Canvas(canvasWidth, canvasHeight);
		root.setLayoutX(TURTLE_X);
		root.setLayoutY(TURTLE_Y);
		turtleView = turtleCanvas.getGraphicsContext2D();	
		root.getChildren().add(turtleCanvas);		
	}
	
	
	private void setCanvas(){
		Paint color = turtleSettings.getBackgroundColor();		
		BackgroundFill backgroundColor = new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(backgroundColor);	
		root.setBackground(background);
	}
	
	private void setTurtle(){
		turtleView.clearRect(TURTLE_X, TURTLE_Y, canvasWidth, canvasHeight);
		if (turtleSettings.getTurtleImage() != null) {
			turtleImage = turtleSettings.getTurtleImage();
		}
		else {
			turtleImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/turtle.png"));
		}
		turtleView.setStroke(turtleSettings.getPenColor());
		
		turtleView.stroke();
		//turtleView.
		turtleView.drawImage(turtleImage, currX - TURTLE_SIZE/2, currY - TURTLE_SIZE/2, TURTLE_SIZE, TURTLE_SIZE);
	}
	
//	private void setTurtlePath(){
//		for (Type line : turtleLines){
//			currX = ;
//			currY = ;
//			
//			
//			
//		}
//	}
	
	
}