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
 * Created by Soravit on 12/17/2016.
 */
public class TurtleIcons {

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
        box.setSpacing(20);
        scrollPane.setContent(box);
        scrollPane.setPrefWidth(130);
        scrollPane.setPrefHeight(50);
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
            imageView.setFitWidth(25);
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
