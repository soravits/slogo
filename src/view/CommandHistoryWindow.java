package view;
import view.data.DataIn;
import view.data.DataOut;
import java.util.Queue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class CommandHistoryWindow {
	private int height;
	private int width;
	Stage stage;
	Group group;
	Scene scene;
	TextArea popupScene;
	DataOut DataOut;

	CommandHistoryWindow(int height, int width, DataOut DataOut) {
		this.stage=new Stage();
		this.popupScene = new TextArea();
		this.DataOut=DataOut;
		this.height=height;
		this.width=width;
		this.group=new Group();
		this.scene=new Scene(group);
		init();
		
	}
	public void init() {
        popupScene = new TextArea();
        stage.setTitle("History");
        popupScene.setEditable(false);
		popupScene.setPrefWidth(width);
		popupScene.setPrefHeight(height);
		popupScene.setLayoutX(width);
		popupScene.setLayoutY(height);
		
		group.getChildren().add(popupScene);
		
	}
	

	public void displayHistory() {
		Queue<String> history= DataOut.getCommandHistory();
		while (!history.isEmpty()) {
			popupScene.appendText(history.poll()+"\n");
		}
        stage.setScene(scene);
        stage.show();
	}

}
