package view.ui;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Map;

/**
 * @author Soravit
 */

public class TurtleIcons {

    private static double IMAGE_SPACING = 20;
    private static double SCROLLPANE_HEIGHT = 50;
    private static double SCROLLPANE_WIDTH = 130;
    private static double IMAGE_WIDTH = 25;

    private Group root;
    private ScrollPane scrollPane;
    private HBox box;
    private Map<Double, ImageView> turtleMap;
    private FileChooser fileChooser;

    public TurtleIcons(Map<Double, ImageView> turtleMap){
        this.turtleMap = turtleMap;
        fileChooser = new FileChooser();
        root = new Group();
        box = new HBox();
        scrollPane = new ScrollPane();
        box.setSpacing(IMAGE_SPACING);
        scrollPane.setContent(box);
        scrollPane.setPrefWidth(SCROLLPANE_WIDTH);
        scrollPane.setPrefHeight(SCROLLPANE_HEIGHT);
        root.getChildren().add(scrollPane);
        update();
    }

    public Group getRoot(){
        return root;
    }

    public void update(){
        box.getChildren().clear();
        for(Map.Entry<Double, ImageView> entry : turtleMap.entrySet()){
            ImageView imageView = new ImageView(entry.getValue().getImage());
            imageView.setFitWidth(IMAGE_WIDTH);
            imageView.setPreserveRatio(true);
            imageView.setOnMouseClicked(event -> {
                changeImage(imageView);
                entry.getValue().setImage(imageView.getImage());
            });
            box.getChildren().add(imageView);
        }
    }


    private void changeImage(ImageView imageView){
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }
}
