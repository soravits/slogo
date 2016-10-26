package view.ui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;

/**
 * 
 * The purpose of this class is to display the interface the user can use to change settings
 * and to return the results of these settings
 * 
 * 
 * @author Diane Hadley
 *
 */

public class GeneralSettings implements UIAttributes{

	private Group root = new Group();
	private ComboBox<String> languageComboBox;
	private Controller controller;
	
	private static int LANGUAGE_COMBOBOX_X = 140;
	private static int LANGUAGE_COMBOBOX_Y = 10;
	
	
	public GeneralSettings(Controller controller){
		super();
		this.controller = controller;

	}


	/*
	 * returns the root with all visualizations of 
	 * how the user can update settings
	 */
	public Group getRoot(){
		makeLanguageComboBox();
		return root;
	}



	/*
	 * returns the selected language
	 */
	public String getLanguage(){
		return languageComboBox.getValue();
	}


	private void makeLanguageComboBox(){
		ObservableList<String> languageOptions = FXCollections.observableArrayList(
				uiResources.getString("English"), uiResources.getString("Chinese"),
				uiResources.getString("French"), uiResources.getString("German"),
				uiResources.getString("Italian"), uiResources.getString("Portuguese"),
				uiResources.getString("Russian"), uiResources.getString("Spanish"));		

		languageComboBox = new ComboBox<String>(languageOptions);
		languageComboBox.setValue(uiResources.getString("English"));
		
		languageComboBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue color, String s1, String s2) {
				controller.setLanguage(languageComboBox.getValue());
			}
		});	
		
		root.getChildren().add(uiBuilder.setControlLayout(languageComboBox, LANGUAGE_COMBOBOX_X, LANGUAGE_COMBOBOX_Y, "generalcontrol"));
	}

}