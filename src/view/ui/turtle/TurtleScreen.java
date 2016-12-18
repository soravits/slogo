package view.ui.turtle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import controller.Controller;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.TurtleState;
import view.data.ViewData;
import view.ui.UIAttributes;
import view.ui.UIBuilder;

/**
 * The purpose of this class is to create the root that visualizes the turtle.
 * This root can then be passed to Window to be displayed in the scene
 * @author Diane Hadley
 */

public class TurtleScreen implements UIAttributes{

    private Pane root = new Pane();
    private TurtleSettings turtleSettings;
    private GraphicsContext turtleView;
    private ViewData viewData;
    private TurtleViewMap turtleViewMap = new TurtleViewMap();
    private UIBuilder uiBuilder = new UIBuilder();
    private Collection<Double> activeTurtles;
    private Collection<ImageView> stamps;
    private Set<TurtleState> previouslyStamped;

    private static final int TURTLE_X = 10;
    private static final int TURTLE_Y = 55;
    private static final int TURTLE_SIZE = 20;
    private static final int VIEW_TURTLE_STATE_HEIGHT = 120;
    private static final int VIEW_TURTLE_STATE_WIDTH = 200;

    private int canvasWidth;
    private int canvasHeight;
    private double originX;
    private double originY;


    /*
     * initiates TurtleCanvas and sets instance of TurtleSettings
     */

    public TurtleScreen(Stage stage, ViewData viewData, Controller controller){
        super();
        this.viewData = viewData;
        this.turtleSettings = new TurtleSettings(stage, this, viewData, controller);
        this.stamps = new ArrayList<ImageView>();
        this.previouslyStamped = new HashSet<TurtleState>();
        this.canvasWidth = TURTLE_CANVAS_WIDTH;
        this.canvasHeight = TURTLE_CANVAS_HEIGHT;		
        this.originX = canvasWidth/2;
        this.originY = canvasHeight/2;		
        makeCanvas();
        updateTurtles();

    }


    /*
     * returns root with all visualization of turtle
     * 
     */	
    public Pane getRoot(){
        setCanvas();
        return root;
    }	

    /*
     * returns instance of TurtleSettings
     */
    public TurtleSettings getTurtleSettings(){
        return turtleSettings;
    }



    public void updateTurtles(){		
        Collection<Double> ids = viewData.getIDs();	
        activeTurtles = viewData.getTurtlesToModify();
        drawStamps();
        updateViewMapKey(ids);
        setActiveTurtleToggle();

        for (double id : ids){	

            setViewTurtleStateFromImage(id);

            addTurtleToScene(id);

            drawTurtlePath(id);				

            if (viewData.getShowTurtle(id)){											
                formatTurtle(id);
            }		
            else {
                root.getChildren().remove(turtleViewMap.getImage(id));
            }
        }	
    }


    public void resetTurtle() {
        turtleView.clearRect(TURTLE_X, TURTLE_Y, canvasWidth, canvasHeight);
        turtleView.beginPath();
        turtleView.moveTo(originX, originY);
    }	

    public void updateViewMapImages(){
        for (double id : activeTurtles){
            root.getChildren().remove(turtleViewMap.getImage(id));
            turtleViewMap.setImage(id, new ImageView(turtleSettings.getTurtleImage()));
            formatTurtle(id);
            root.getChildren().add(turtleViewMap.getImage(id));
            setViewTurtleStateFromImage(id);			

        }		
    }


    public void setActiveTurtleToggle(){

        boolean showActive = turtleSettings.getActiveTurtleToggle();

        for (double id : turtleViewMap.getIDs()){
            if (activeTurtles.contains(id) && showActive){
                showAsActiveTurtle(id);
            }
            else{
                dontAsShowActiveTurtle(id);
            }

        }
    }


    private void dontAsShowActiveTurtle(double id) {
        turtleViewMap.getImage(id).setEffect(null);
    }


    private void showAsActiveTurtle(double id) {
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.AQUA);			

        ImageView iv = turtleViewMap.getImage(id);
        iv.setEffect(shadow);
    }

    private void updateViewMapKey(Collection<Double> ids) {			

        for (double id : ids){	

            if (!turtleViewMap.getIDs().contains(id)){
                turtleViewMap.setAttributes(id);							
            }	
        }
    }

    private void addTurtleToScene(double id){
        if (!root.getChildren().contains(turtleViewMap.getImage(id))){				

            root.getChildren().add(turtleViewMap.getImage(id));
        }
    }


    private void setViewTurtleStateFromImage(double id) {
        ImageView iv = turtleViewMap.getImage(id);

        Group root = getTurtleStateRoot(id);
        Stage stage = getTurtleStateStage(id, root);	
        stage.setX(originX + viewData.getTurtleX(id) + VIEW_TURTLE_STATE_WIDTH/2);
        stage.setY(originY - viewData.getTurtleY(id) + VIEW_TURTLE_STATE_HEIGHT + TURTLE_SIZE*2);
        setShowTurtleStateSettings(iv, stage);
        setClickToChangeActiveState(iv, id);		
    }

    private void setClickToChangeActiveState(ImageView iv, double id){
        iv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {	    	
                viewData.changeActiveTurtle(id);
                setActiveTurtleToggle();
                getRoot();
            }
        });
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

    private Stage getTurtleStateStage(Double id, Group root) {
        Stage stage = new Stage();
        stage.setResizable(false);
        Scene scene = new Scene(root, VIEW_TURTLE_STATE_WIDTH, VIEW_TURTLE_STATE_HEIGHT);		
        stage.setScene(scene);
        stage.setTitle("Turtle " + id.toString());
        return stage;
    }

    private Group getTurtleStateRoot(Double id) {
        Group root = new Group();

        Text posX = uiBuilder.getText(10, 20, "Position X: " + viewData.getTurtleX(id));
        Text posY = uiBuilder.getText(10, 40, "Position Y: " + viewData.getTurtleY(id));
        Text heading = uiBuilder.getText(10, 60, "Heading: " + viewData.getTurtleAngle(id));
        Text penStatus = uiBuilder.getText(10, 80, "Pen Down: " + viewData.isPenDown(id));

        root.getChildren().addAll(posX, posY, heading, penStatus);
        return root;
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

    private void drawTurtlePath(double id){	
        double [][] line = viewData.getLines(id);			
        turtleView.setLineWidth(turtleSettings.getPenThickness());
        turtleView.setStroke(turtleSettings.getPenColor());
        turtleView.strokeLine(
                              originX + line[0][0], 
                              originY - line[0][1],
                              originX + line[1][0],
                              originY - line[1][1]
                );						
    }

    private void formatTurtle(double id){
        ImageView iv = turtleViewMap.getImage(id);

        double posX = originX + viewData.getTurtleX(id);
        double posY = originY - viewData.getTurtleY(id);
        double angle = viewData.getTurtleAngle(id);	

        if (turtleIsOffCanvas(posX, posY)){
            root.getChildren().remove(iv);
        }

        else {

           adjustImageView(posX, posY, angle, iv);
        }	
    }


    private boolean turtleIsOffCanvas(double posX, double posY) {
        return posX > canvasWidth || posX < 0 || posY > canvasHeight || posY < 0;
    }	

    private void drawStamps(){
        List<TurtleState> currentStamps = this.viewData.getStamps();
        if (currentStamps.size() == 0){
            for (ImageView iv : stamps){
                root.getChildren().remove(iv);
            }
            stamps.clear();
            previouslyStamped.clear();
        }
        else{
            for (TurtleState t : currentStamps){
                if (!previouslyStamped.contains(t))
                {
                    ImageView iv = new ImageView();
                    stamps.add(iv);
                    Image im = turtleViewMap.getImage((double) t.getImageIndex()).getImage();
                    iv.setImage(im);
                    double posX = originX + t.getTurtleX();
                    double posY = originY - t.getTurtleY();
                    double angle = t.getTurtleAngle();
                    adjustImageView(posX, posY, angle, iv);
                    root.getChildren().add(iv);
                    previouslyStamped.add(t);
                }
            }
        }
    }
    
    private void adjustImageView(double posX, double posY, double angle, ImageView iv){
        iv.setRotate(angle);
        iv.setFitWidth(TURTLE_SIZE);
        iv.setFitHeight(TURTLE_SIZE);
        iv.setX(posX - TURTLE_SIZE/2);
        iv.setY(posY - TURTLE_SIZE/2);
    }

}