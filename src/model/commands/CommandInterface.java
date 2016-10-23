package model.commands;

import model.Model;

/**
 * Every specified command has its own class. Each class will have a special operation that it will
 * perform, but the implementation of the specific operations are hidden in the execute() method
 * specified in this interface. All Command classes implement this basic interface
 * @author Brian
 *
 */
public abstract interface CommandInterface {

    /*
     * Perform the given operation needed depending on the command specified by the Interpreter
     */
    public abstract double execute();
    
    /**
     * Execute the correct command specified by the relection instantiation
     * @param params
     * @param model
     * @return the double needed for the next node in the expression tree
     */
    public double execute(double[] parameters, Model slogoModel);
}
