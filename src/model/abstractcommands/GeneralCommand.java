package model.abstractcommands;

public abstract class GeneralCommand implements CommandInterface{

    private double[] params;
    
    public GeneralCommand(double[] parameters){
        params = parameters;
    }
    
    public double[] getParams(){
        return params;
    }
    @Override
    public abstract double execute () throws Exception;

    public double sumParams(){
        double sum = 0;
        for (double x : params){
            sum += x;
        }
        return sum;
    }
}
