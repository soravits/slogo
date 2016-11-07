package view.ui;

import java.util.Collection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//This entire file is my masterpiece. - Pim Chuaylua pc131

public class CommandHistoryWindow implements UIAttributes{
	private Stage stage;
	private Group group;
	private Scene scene;
	private VBox vbox;
	private Window window;
	
	private static final int WINDOW_HEIGHT = 600;
	private static final int WINDOW_WIDTH = 300;
	private static final int VBOX_FIRST_X = 10;
	public static final int VBOX_PADDING = 20;
	public static final int HBOX_PADDING = 10;

	CommandHistoryWindow(Window window) {
		super();
		this.stage=new Stage();
		this.group=new Group();
		this.scene=new Scene(group,WINDOW_WIDTH,WINDOW_HEIGHT);
		this.vbox=new VBox(VBOX_PADDING);
		this.window = window;
		initWindow();
	}
	
	private void initWindow() {
        vbox.setPadding(new Insets(VBOX_PADDING));
        vbox.setLayoutX(VBOX_FIRST_X);
        vbox.setSpacing(VBOX_PADDING-10);
        
        stage.setResizable(false);
        stage.setTitle("History");
        stage.setWidth(WINDOW_WIDTH);
        stage.setHeight(WINDOW_HEIGHT);

        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setLayoutX(scene.getWidth()-scrollBar.getWidth());
        scrollBar.setMin(0);
        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setPrefHeight(WINDOW_HEIGHT);
        scrollBar.setMax(WINDOW_HEIGHT);
        
        scrollBar.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    vbox.setLayoutY(-new_val.doubleValue());
                }
        });
        
        group.getChildren().addAll(scrollBar,vbox);
        
	}
	
	
	
	public void updateCommandHistory(Collection<String> commandHistory) {
		for (String command:commandHistory) {
			HBox hbox = new HBox(HBOX_PADDING);
			hbox.getChildren().add(new Text(command));
			hbox.getChildren().add(getRedoButton(command));
			vbox.getChildren().add(hbox);
		}
	}
	
	public Button getRedoButton(String command) {
		Button button=new Button("Redo");
		button.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {  
		    	try {
					window.updateViewData(command);
					window.updateUI();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		return button;
	}
	
	public void show() {
		stage.setScene(scene);
        stage.show();
	}

}
