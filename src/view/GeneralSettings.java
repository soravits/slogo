package view;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;


/**
 * 
 * The purpose of this class is to display the interface the user can use to change settings
 * and to return the results of these settings
 * 
 * 
 * @author Diane Hadley
 *
 */

public class GeneralSettings{
	
	private Group root = new Group();
	private ComboBox<String> languageComboBox;
	private ResourceBundle generalResources;
	
	private static int LANGUAGE_COMBOBOX_X = 140;
	private static int LANGUAGE_COMBOBOX_Y = 10;
	
	public GeneralSettings(ResourceBundle resources){
		generalResources = resources;
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
				generalResources.getString("English"), generalResources.getString("Chinese"),
				generalResources.getString("French"), generalResources.getString("German"),
				generalResources.getString("Italian"), generalResources.getString("Portuguese"),
				generalResources.getString("Russian"), generalResources.getString("Spanish"));		
			
		languageComboBox = new ComboBox<String>(languageOptions);
		languageComboBox.setValue(generalResources.getString("English"));
		root.getChildren().add(setControlLayout(languageComboBox, LANGUAGE_COMBOBOX_X, LANGUAGE_COMBOBOX_Y));
	}
	
	private Control setControlLayout(Control control, int x, int y) {
		control.setLayoutX(x);
		control.setLayoutY(y);
		control.setFocusTraversable(false);
		control.getStyleClass().add("generalcontrol");
		return control;
	}
	
	
}