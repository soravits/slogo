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
    public double[] getParams(){
        return params;
    }
    
    @Override
    public abstract double execute () throws Exception;

    /**
     * @return sum of all of the parameters in the input array
     */
    public double sumParams(){
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
    public double normalizeAngle(double angle){
        double normalizedAngle = angle % 360;
        if (normalizedAngle < 0){
            normalizedAngle += 360;
        }
        return normalizedAngle;
    }
}
