import java.util.List;
import javafx.scene.Group;

/**
 *The purpose of this class is to create the root that visualizes the commandLine
 *and to return the input in the command line as a list of commands so that
 *they can be executed
 *
 * @author Diane Hadley
 *
 */



public interface CommandLine{
	
	

	/*
	 * returns root with all visualization of commandLine
	 * 
	 */	
	public Group getRoot();
	
	
	/*
	 * returns list of objects which are each a line of input in the command line
	 */
	public List<Object> getCommand();
	
}