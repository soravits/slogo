package view.ui.turtle;
import java.util.Collection;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import model.LineModel;
import model.LineState;
import model.TurtleMap;
import model.TurtlePair;
import model.TurtleState;
import view.ui.UIAttributes;


/**
 * The purpose of this class is to create the root that visualizes the turtle.
 * This root can then be passed to UI to be displayed in the scene
 * 
 * @author Diane Hadley
 */


public class TurtleScreen implements UIAttributes{
	
	private Pane root = new Pane();
	private TurtleSettings turtleSettings;
	private GraphicsContext turtleView;
	private TurtleVisualMap turtleVisualMap = new TurtleVisualMap();
	
	private static int TURTLE_X = 10;
	private static int TURTLE_Y = 55;
	private int canvasWidth;
	private int canvasHeight;
	private double originX;
	private double originY;
	
	private static int TURTLE_SIZE = 20;
	

	/*
	 * initiates TurtleCanvas and sets instance of TurtleSettings
	 */
	
	public TurtleScreen(Stage stage){
		super();
		this.turtleSettings = new TurtleSettings(stage, this);
		this.canvasWidth = TURTLE_CANVAS_WIDTH;
		this.canvasHeight = TURTLE_CANVAS_HEIGHT;		
		this.originX = canvasWidth/2;
		this.originY = canvasHeight/2;		
		makeCanvas();
		//resetTurtle();
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
	
	
//	public void resetTurtles(Collection<TurtlePair> turtles){
//				
//	}
		
	public void updateTurtles(TurtleMap turtleMap){
		
		turtleView.beginPath();
		turtleView.moveTo(originX, originY);
		
		Collection<TurtlePair> turtlePairs = turtleMap.getTurtles();
		
	//	turtleMap.
		
		for (TurtlePair turtlePair : turtlePairs){
			TurtleState turtleState = turtlePair.getTurtle();
			
			
			if (turtleState.getShowTurtle()){
				LineState lines = turtlePair.getLines();
				viewTurtlePath(lines);
				
				viewTurtle();
			}
			
			
		}
		
		
				
		
		turtleState.getTurtleAngle();
		
		
		
		turtleX = originX + turtleState.getTurtleX();
		
		turtleY = originY - turtleState.getTurtleY();
			
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
		turtleView.setStroke(turtleSettings.getPenColor());	
		turtleView.stroke();	
		if (isTurtleShowing){
			viewTurtle();
		}
	}
	
	
	
	private void viewTurtlePath(LineState lines){
		Collection<LineModel> linePoints = lines.getLines();
		
		for (LineModel line : linePoints){
			
			turtleView.strokeLine(
					originX + line.getPosition1().getX(), 
					originY - line.getPosition1().getY(),
					originX + line.getPosition2().getX(),
					originY - line.getPosition2().getY()
			);				
		}
	}
	
	
	private void viewTurtle(Image image){

		
		if (image == null) {
			image = new Image(getClass().getClassLoader().getResourceAsStream("resources/turtle.png"));
		}
		
		rotateTurtle();
	}
	
	private void rotateTurtle(){
		turtleView.save();
		Rotate rotate = new Rotate(angle, posX, posY);
		turtleView.setTransform(rotate.getMxx(), rotate.getMyx(), rotate.getMxy(), 
				rotate.getMyy(), rotate.getTx(), rotate.getTy());
		turtleView.drawImage(turtleImage, posX - TURTLE_SIZE/2, posY - TURTLE_SIZE/2, TURTLE_SIZE, TURTLE_SIZE);
		turtleView.restore();
			
	}	
	
	
	private void updateImageMap(){
		
	}
	
}