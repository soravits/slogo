package model.abstractcommands;

/**
 * Interface specifying that all Command classes have a method called execute() that can be called
 * after initializing the class via reflection
 * @author Brian
 *
 */
public interface CommandInterface {

    /**
     * Modify the current Model via an interface that is passed through to each command. Each command has
     * a different specific implementation/functionality, but all of them are enacted by initializing with
     * an array of doubles and an interface and calling Command.execute(). Every command returns a double that
     * may be calculated or may simply be the restatement of an input
     * @return a double : output value for each command that is read to the console
     * @throws Exception for certain types of command-specific errors (dividing by zero, etc)
     */
    public abstract double execute() throws Exception;
    
    //public abstract double undo() throws Exception;
}
