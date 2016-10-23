package view;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


/**
 * The purpose of this class is to create the root that visualizes the turtle.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */


public class Turtle extends UIBuilder{
	
	private Pane root = new Pane();
	private TurtleSettings turtleSettings;
	//private Canvas turtleCanvas;
	private GraphicsContext turtleView;
	private Image turtleImage;
	
	private static int TURTLE_X = 10;
	private static int TURTLE_Y = 55;
	private int canvasWidth;
	private int canvasHeight;
	private double originX;
	private double originY;
	private double currX;
	private double currY;
	
	
	
	/*
	 * initiates Turtle and sets instance of TurtleSettings
	 */
	
	public Turtle(TurtleSettings settings){
		super();
		this.turtleSettings = settings;
		this.canvasWidth = TURTLE_CANVAS_WIDTH;
		this.canvasHeight = TURTLE_CANVAS_HEIGHT;	
		this.originX = canvasWidth/2;
		this.originY = canvasHeight/2;
		this.currX = originX;
		this.currY = originY;
		bindInstanceVariables();
		makeCanvas();
		makeTurtle();
		getButtons();
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
	
	private void makeTurtle(){
		turtleView.beginPath();
//		turtleView.setFill(turtleSettings.getPenColor());
//		int radius = 10;
//		turtleView.fillOval(canvasCenterX - radius, canvasCenterY - radius, radius, radius);		
		
	}
	
	private void setTurtle(){
		
		turtleImage = new Image(getClass().getClassLoader().getResourceAsStream("resources/turtle.png"));
		if (turtleSettings.getTurtleImage() != null) {
			turtleImage = turtleSettings.getTurtleImage();
		}
		
		turtleView.drawImage(turtleImage, originX - 15, originY - 15, 30, 30);
		
	}
	
	
	
	
	//TESTING
	int m = 20;
	
	private void getButtons(){
		
		Button reset = makeButton(300, 10, 
				uiResources.getString("ResetTurtle"), "turtlecontrol");
		reset.setOnAction((event) -> {
			turtleView.clearRect(TURTLE_X, TURTLE_Y, canvasWidth, canvasHeight);
			turtleView.setStroke(Color.BLACK);
			turtleView.lineTo(currX, currY);
			turtleView.drawImage(turtleImage, currX - 15 , currY - 15, 30, 30);
			
			currX = currX+m;
			currY += 20;
			m = m*(-1);
			turtleView.stroke();
		});	
		
	
		
		root.getChildren().addAll(reset);
	}
	
	
	
}