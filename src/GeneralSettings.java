import javafx.scene.Group;


/**
 * 
 * The purpose of this class is to display the interface the user can use to change settings
 * and to return the results of these settings
 * 
 * 
 * @author Diane
 *
 */

public interface GeneralSettings{
	
	

	/*
	 * returns the root with all visualizations of 
	 * how the user can update settings
	 */
	public Group getRoot();
	
	
	
	/*
	 * returns the selected language
	 */
	public Object getLanguage();
	
	
}