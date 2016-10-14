import java.util.ArrayList;

/**
 *View External API is mainly responsible of sending data to the back end and receiving data from the backend. 
 * @author Pim
 */
public interface Data {

    /**
     *Add each command the user types to some data structure in the object
     */
	public void addCommandToList(String commandString);
	
	/**
     *Add the language to the object
     */
	public void addLanguage(String languageString);
	
	/**
     *Add changes made in the workspace into some data structure. 
     */
	public void addWorkspaceChanges();
	
	/**
     *Check if the observer sees error in the backend 
     */
	public boolean ifError();
	
	/**
     *Returns error message as a string, if ifError() is true
     */
	public String getErrorMessage();
	
	/**
     *get language String from the object
     */
	public String getLanguage();
	
	/**
     *Return compressed data including language, data structure containing command lines, changes made in workspace from UI 
     *in an object to be sent to the back-end
     */
    public Data getAllDataFromUI();
    
    /**
     *The backend add results from the execution of command lines to some data structure in the data object,
     *which will be sent to be displayed on UI.
     */
    public void addResultsFromController();

    /**
     *Return compressed data of the results of the commands execution from the backend controller that are to be
     *displayed on the UI.
     */
    public Data getResultsFromController();

}
