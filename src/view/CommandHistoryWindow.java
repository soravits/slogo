package view;
import view.data.DataIn;
import java.util.Collection;
import java.util.HashMap;
import java.util.Queue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CommandHistoryWindow {
	private int height;
	private int width;
	Stage stage;
	Group group;
	Scene scene;
	TextArea commandList;
	VBox VBox;
	private UI ui;
	private CommandLine commandLine;

	CommandHistoryWindow(UI ui,CommandLine commandLine,int height, int width) {
		this.stage=new Stage();
		this.commandList = new TextArea();
		this.height=height;
		this.width=width;
		this.group=new Group();
		this.scene=new Scene(group,width,height);
		this.VBox=new VBox(20);
		this.ui=ui;
		this.commandLine=commandLine;
		init();
	}
	
	public void init() {
        VBox.setPadding(new Insets(20));
        stage.setTitle("History");
        stage.setWidth(width);
        stage.setHeight(height);
        group.getChildren().add(VBox);
	}
	
	public void updateCommandHistory(Collection<String> commandHistory) {
		for (String command:commandHistory) {
			HBox HBox = new HBox(10);
			HBox.getChildren().add(new Text(command));
			HBox.getChildren().add(getRedoButton(command));
			VBox.getChildren().add(HBox);
		}
		System.out.println("size: "+commandHistory.size());
	}
	
	public Button getRedoButton(String command) {
		Button button=new Button("Redo");
		button.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {  
		    	commandLine.setCommand(command);
		    	try {
					ui.updateDataIn();
					commandLine.setCommand("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
		return button;
	}
	/*
	public Button getUndoButton() {
		Button button=new Button("Undo");
		button.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {  
		    }
		});
		return button;
	}*/
	
	public void show() {
		stage.setScene(scene);
        stage.show();
	}

}
