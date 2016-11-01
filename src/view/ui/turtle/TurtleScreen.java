package view.ui.turtle;
import java.util.Collection;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.LineModel;
import model.LineState;
import model.Model;
import model.TurtleMap;
import model.TurtleState;
import view.ui.UIAttributes;
import view.ui.UIBuilder;


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
	private UIBuilder uiBuilder = new UIBuilder();
	
	private static final int TURTLE_X = 10;
	private static final int TURTLE_Y = 55;
	private static final int TURTLE_SIZE = 20;
	
	private int canvasWidth;
	private int canvasHeight;
	private double originX;
	private double originY;
	private int currID;

	/*
	 * initiates TurtleCanvas and sets instance of TurtleSettings
	 */
	
	public TurtleScreen(Stage stage, Model model){
		super();
		this.turtleSettings = new TurtleSettings(stage, this);
		this.canvasWidth = TURTLE_CANVAS_WIDTH;
		this.canvasHeight = TURTLE_CANVAS_HEIGHT;		
		this.originX = canvasWidth/2;
		this.originY = canvasHeight/2;		
		makeCanvas();
		this.currID = 1;
		updateTurtles(model.getTurtleMap());
	
	}
	
	
	/*
	 * returns root with all visualization of turtle
	 * 
	 */	
	public Pane getRoot(){
		setCanvas();
		return root;
	}
	
	
	public int getCurrID(){
		return currID;
	}
	
	public TurtleSettings getTurtleSettings(){
		return turtleSettings;
	}
	
		
	public void updateTurtles(TurtleMap turtleMap){
		resetTurtle();
		
		Collection<Object> ids = turtleMap.getIDs();
		
		updateViewMap(turtleMap);
		
		for (Object id : ids){
			TurtleState turtleState = turtleMap.getTurtle(id);
			
			
			if (turtleState.getShowTurtle()){
				LineState lines = turtleMap.getLineState(id);
				viewTurtlePath(lines);				
				double posX = originX + turtleState.getTurtleX();
				double posY = originY - turtleState.getTurtleY();
				double angle = turtleState.getTurtleAngle();				
				viewTurtle(angle, posX, posY, id);
			}		
			else {
				root.getChildren().remove(turtleViewMap.getImage(id));
			}
		}	
	}


	private void updateViewMap(TurtleMap turtleMap) {
		Collection<Object> ids = turtleMap.getIDs();
		for (Object id : ids){
			
			if (!turtleViewMap.getIDs().contains(id)){
				turtleViewMap.setAttributes(id);				
			}
			setImageViewSettings(turtleMap, id);
			
		}
		
		
	}


	private void setImageViewSettings(TurtleMap turtleMap, Object id) {
		ImageView iv = turtleViewMap.getImage(id);
		
		if (!root.getChildren().contains(turtleViewMap.getImage(id))){				
			root.getChildren().add(iv);
		}

		Group root = getTurtleStateRoot(turtleMap, id);
		Stage stage = getTurtleStateStage(id, root);				
		setShowTurtleStateSettings(iv, stage);
	}


	private void setShowTurtleStateSettings(ImageView iv, Stage stage) {
		iv.setOnMouseEntered(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	
				stage.show(); 

			    }
			});
		
		iv.setOnMouseExited(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		    	
				stage.hide();

			    }
			});
	}


	private Stage getTurtleStateStage(Object id, Group root) {
		Stage stage = new Stage();
		stage.setResizable(false);
		Scene scene = new Scene(root, 200, 100);		
		stage.setScene(scene);
		stage.setTitle("Turtle " + id.toString());
		return stage;
	}


	private Group getTurtleStateRoot(TurtleMap turtleMap, Object id) {
		Group root = new Group();
		
		Text pos = uiBuilder.getText(10, 20, "Position: " + turtleMap.getTurtle(id).getPosition().toString()); 
		Text heading = uiBuilder.getText(10, 40, "Heading: " + turtleMap.getTurtle(id).getTurtleAngle());
		Text penColor = uiBuilder.getText(10, 60, "Pen Color: " + turtleViewMap.getPenColor(id));
		Text penStatus = uiBuilder.getText(10, 80, "Pen Down: " + turtleMap.getLineState(id).isPenDown());
		
		root.getChildren().addAll(pos, heading, penColor, penStatus);
		return root;
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
	
	
	private void viewTurtle(double angle, double posX, double posY, Object id){
		ImageView iv = turtleViewMap.getImage(id);
		iv.setRotate(angle);
		iv.setFitWidth(TURTLE_SIZE);
		iv.setFitHeight(TURTLE_SIZE);
		iv.setX(posX - TURTLE_SIZE/2);
		iv.setY(posY - TURTLE_SIZE/2);
	}	
	
	
}