// This entire file is part of my masterpiece
// Brian Keohane

/*
 * This is the highest-level Abstract Command Class in the command hierarchy. Every command (besides control
 * commands, which are handled differently at the interpreter level) is passed both an interface (which is
 * the model) and an array of doubles (which could be filled with parameters or empty). Since different 
 * commands utilize different interfaces, the only true constant is the double array, so this abstract class
 * provides a constructor to store the input array of doubles as an instance variable. 
 * 
 * This is good design because it reduces the need for redundant code and provides a solid hierarchy from
 * which to branch off and make Turtle, Math, Boolean and Display Commands. The methods that are only
 * used by commands (sumParams() and normalizeAngle(double degrees)) are protected because they are not
 * needed outside of the command hierarchy.
 * Additionally, each of the methods are short, concise, and well named, and the class' methods are well
 * documented.
 */
package model.abstractcommands;

/**
 * All commands take an array of doubles as an input parameter; abstract class utilized by other types of
 * abstract Command classes as a starting point for Command functionality
 * @author Brian
 *
 */
public abstract class GeneralCommand implements CommandInterface{

    private double[] params;
    
    public GeneralCommand(double[] parameters){
        params = parameters;
    }
    
    /**
     * @return the array of input doubles
     */
    protected double[] getParams(){
        return params;
    }
    
    @Override
    public abstract double execute () throws Exception;

    /**
     * @return sum of all of the parameters in the input array
     */
    protected double sumParams(){
        double sum = 0;
        for (double x : params){
            sum += x;
        }
        return sum;
    }
    
    /**
     * @param angle : nominal angle that determines direction which a turtle faces
     * @return an equivalent angle between 0 and 360 degrees
     */
    protected double normalizeAngle(double angle){
        double normalizedAngle = angle % 360;
        if (normalizedAngle < 0){
            normalizedAngle += 360;
        }
        return normalizedAngle;
    }
}
