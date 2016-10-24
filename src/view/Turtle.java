package view;
import java.util.Collection;

import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.LineModel;
import model.LineState;
import model.Model;
import model.Position;
import model.TurtleMap;
import model.TurtlePair;
import model.TurtleState;


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
	private Model model;
	
	private static int TURTLE_X = 10;
	private static int TURTLE_Y = 55;
	private static int TURTLE_SIZE = 30;
	private int canvasWidth;
	private int canvasHeight;
	private double originX;
	private double originY;
	private double currX;
	private double currY;
	private double angle;
	
	
	
	/*
	 * initiates Turtle and sets instance of TurtleSettings
	 */
	
	public Turtle(Stage stage){
		super();
		this.turtleSettings = new TurtleSettings(stage, this);
		//this.model = model;
		this.canvasWidth = TURTLE_CANVAS_WIDTH;
		this.canvasHeight = TURTLE_CANVAS_HEIGHT;	
		this.originX = canvasWidth/2;
		this.originY = canvasHeight/2;
		this.currX = originX;
		this.currY = originY;
		this.angle = 0;
		
		
		//bindInstanceVariables();
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
	
	
	public void clearTurtlePath(){
		turtleView.beginPath();
	}
	
//	private void bindInstanceVariables(){
//		//TODO: bind angle to model angle
//		
//	}
	
	public void updateTurtle(TurtleMap turtleMap){
		TurtleState turtleState = turtleMap.getTurtle();			
		angle = turtleState.getTurtleAngle();
		Boolean isTurtleShowing = turtleState.getShowTurtle();
		
		turtleView.moveTo(originX, originY);
		
		if (isTurtleShowing){
			LineState lines = turtleMap.getLineState();
			setTurtlePath(lines);
		}
	
		
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
		
		rotateTurtle();
			
		turtleView.drawImage(turtleImage, currX - TURTLE_SIZE/2, currY - TURTLE_SIZE/2, TURTLE_SIZE, TURTLE_SIZE);
	}
	
	private void rotateTurtle(){
		ImageView imageView = new ImageView(turtleImage);	//http://stackoverflow.com/questions/33613664/javafx-drawimage-rotated
		imageView.setRotate(angle);
		SnapshotParameters params = new SnapshotParameters();
		params.setFill(Color.TRANSPARENT);
		turtleImage = imageView.snapshot(params, null);
		
		//turtleImage = imageView.getImage();
		
			
	}
	
	
	private void setTurtlePath(LineState lines){
		Collection<LineModel> linePoints = lines.getLines();
		
		for (LineModel line : linePoints){

			
			if (currX != line.getPosition1().getX() + originX ||
					currY != originY - line.getPosition1().getY()){
				currX = line.getPosition1().getX() + originX;
				currY = originY - line.getPosition1().getY();
				turtleView.moveTo(currX, currY);
			}
			
			currX = line.getPosition2().getX() + originX;
			currY = originY - line.getPosition2().getY();
			turtleView.lineTo(currX, currY);
					
		}
	}
	
	
}