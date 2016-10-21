package view;

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

public class GeneralSettings extends UIBuilder{
	
	private Group root = new Group();
	private ComboBox<String> languageComboBox;
	
	private static int LANGUAGE_COMBOBOX_X = 140;
	private static int LANGUAGE_COMBOBOX_Y = 10;
	
	
	public GeneralSettings(){
		super();
		
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
	public Object getLanguage(){
		return null;
	}
	
	
	private void makeLanguageComboBox(){
		
		ObservableList<String> languageOptions = FXCollections.observableArrayList(
				uiResources.getString("English"), uiResources.getString("Chinese"),
				uiResources.getString("French"), uiResources.getString("German"),
				uiResources.getString("Italian"), uiResources.getString("Portuguese"),
				uiResources.getString("Russian"), uiResources.getString("Spanish"));		
			
		languageComboBox = new ComboBox<String>(languageOptions);
		languageComboBox.setValue(uiResources.getString("English"));
		root.getChildren().add(setControlLayout(languageComboBox, LANGUAGE_COMBOBOX_X, LANGUAGE_COMBOBOX_Y, "generalcontrol"));
	}
	
}