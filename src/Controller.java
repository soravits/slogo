/**
 * The purpose of this class is to receive the data from the view and send it to the Parser to be handled. It will
 * also take the tree that is returned by the parser and send it to the interpreter. Essentially, the Controller
 * acts as a gateway to the back-end and facilitates the Parser and Interpreter classes. Currently, it only
 * has an update function, but as the project progresses, it will likely assume more responsibility.
 *
 *
 * @author Soravit
 */
public interface Controller {

    /**
     * This class takes the different data objects/varibles packaged into the data object, modifies the Parser and
     * Interpreter as necessary, and sends the data to the Parser.
     * @param d The data object containing the string to be parsed and other important settings related to the back-end
     */
    public void update(Data d);

}
