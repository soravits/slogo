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
	private TurtleViewMap turtleViewMap = new TurtleViewMap();
	
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
		
	}
	
	
	/*
	 * returns root with all visualization of turtle
	 * 
	 */	
	public Pane getRoot(){
		setCanvas();	
		return root;
	}
	
	public TurtleSettings getTurtleSettings(){
		return turtleSettings;
	}
	
		
	public void updateTurtles(TurtleMap turtleMap){
		resetTurtle();
		
		Collection<TurtlePair> turtlePairs = turtleMap.getTurtles();
		
		Collection<Object> ids = turtleMap.getIDs();
		
		updateViewMap(ids);
		
		for (Object id : ids){
			TurtleState turtleState = turtleMap.getTurtle(id);
					
			if (turtleState.getShowTurtle()){
				LineState lines = turtleMap.getLineState(id);
				viewTurtlePath(lines);				
				viewTurtle(turtleState, id);
			}		
		}	
	}


	private void updateViewMap(Collection<Object> ids) {
		if (ids.size() != turtleViewMap.getIDs().size()){
			for (Object id : ids){
				if (!turtleViewMap.getIDs().contains(id)){
					turtleViewMap.setAttributes(id);				
				}
			}
		}
	}


	private void resetTurtle() {
		turtleView.clearRect(TURTLE_X, TURTLE_Y, canvasWidth, canvasHeight);
		turtleView.beginPath();
		turtleView.moveTo(originX, originY);
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
	
	
	private void viewTurtle(TurtleState turtleState, Object id){
		
		double posX = originX + turtleState.getTurtleX();
		double posY = originY - turtleState.getTurtleY();
		
		
		turtleView.save();
		Rotate rotate = new Rotate(turtleState.getTurtleAngle(), posX, posY);
		turtleView.setTransform(rotate.getMxx(), rotate.getMyx(), rotate.getMxy(), 
				rotate.getMyy(), rotate.getTx(), rotate.getTy());
		turtleView.drawImage(turtleViewMap.getImage(id), posX - TURTLE_SIZE/2, 
				posY - TURTLE_SIZE/2, TURTLE_SIZE, TURTLE_SIZE);
		turtleView.restore();		
	}	
	
	
}