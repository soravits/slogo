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
import javafx.scene.transform.Rotate;
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
		this.canvasWidth = TURTLE_CANVAS_WIDTH;
		this.canvasHeight = TURTLE_CANVAS_HEIGHT;	
		this.originX = canvasWidth/2;
		this.originY = canvasHeight/2;
		this.angle = 0;
		makeCanvas();
		resetTurtle();
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
	
	
	public void resetTurtle(){
		turtleView.beginPath();
		currX = originX;
		currY = originY;
		turtleView.moveTo(originX, originY);
		
	}
	
	
	public void updateTurtle(TurtleMap turtleMap){
		TurtleState turtleState = turtleMap.getTurtle();			
		angle = turtleState.getTurtleAngle();
		Boolean isTurtleShowing = turtleState.getShowTurtle();
		
		resetTurtle();
			
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
		
	}
	
	private void rotateTurtle(){

		turtleView.save();
		Rotate rotate = new Rotate(angle, currX, currY);
		turtleView.setTransform(rotate.getMxx(), rotate.getMyx(), rotate.getMxy(), 
				rotate.getMyy(), rotate.getTx(), rotate.getTy());
		turtleView.drawImage(turtleImage, currX - TURTLE_SIZE/2, currY - TURTLE_SIZE/2, TURTLE_SIZE, TURTLE_SIZE);
		turtleView.restore();
			
	}
	
	
	private void setTurtlePath(LineState lines){
		Collection<LineModel> linePoints = lines.getLines();
		for (LineModel line : linePoints){
			
			if (currX != originX + line.getPosition1().getX() ||
					currY != originY - line.getPosition1().getY()){
				
				currX = originX + line.getPosition1().getX();
				currY = originY - line.getPosition1().getY();
				turtleView.moveTo(currX, currY);
			}
			
			currX = originX + line.getPosition2().getX();
			currY = originY - line.getPosition2().getY();
			turtleView.lineTo(currX, currY);
					
		}
	}
	
	
}