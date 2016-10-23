package view.data;


/**
 * the purpose of this class is to sort data from the back end 
 * so that visualization classes can call just the data they need
 * 
 * @author Diane
 *
 */

public interface DataSorter{
	
	
	/*
	 * returns data that will update the workspace
	 */
	public Object getWorkspaceData();
	
	/*
	 * returns data that will update the console
	 */
	public Object getConsoleData();
	
	/*
	 * returns data that will update the turtle
	 */
	public Object getTurtleData();
	
}