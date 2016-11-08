// This entire file is part of my masterpiece.
// Soravit Sophastienphong

/**
 * This class is responsible for taking user input from the front-end and executing the command(s) represented
 * by the input in the back-end. The public API provides methods for updating the view based on the model, changing
 * the language of the interpreter, and executing input that's written in a file. I believe this class is an example
 * of good design because of the way it acts as an interface between the view and the model. As shown in the
 * processCommand() method, the view is only updated if the model updates successfully based on the inputted command.
 * Furthermore, the view does gain complete access to the public methods in the Model class, since it only has access
 * to the ViewData object containing only the methods that it needs to update, while the rest of the methods in the Model
 * class are encapsulated. This class also implements the Observer pattern and acts as an observable for the view and
 * an observer for the model. As implemented in the update() method, any change to the model updates the controller,
 * which updates the view.
 */

package controller;
import error.InvalidCommandException;
import error.InvalidParametersException;
import error.InvalidSyntaxException;
import model.Model;
import view.data.ViewData;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Soravit Sophastienphong
 */

public class Controller extends Observable implements Observer{
    private Model model;
    private Interpreter interpreter;
    private ViewData viewData;

    /**
     * @param viewData The front-end's version of the model that's visually represented by the view.
     */
    public Controller(ViewData viewData){
        this.viewData = viewData;
        model = new Model();
        interpreter = new Interpreter(model);
        model.addObserver(this);
    }
    /**
     * This class takes the different data objects/variables packaged into the data object, modifies the controller.Parser and
     * Interpreter as necessary, and sends the data to the controller.Parser.
     * @param input The command inputted by the user
     * @throws InvalidSyntaxException If the syntax of a command is incorrect.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     * @throws InvalidParametersException If there is an error with passing invalid parameters to a command.
     */
    public void processCommand(String input) throws InvalidCommandException, InvalidSyntaxException, InvalidParametersException {
    	model.addCommand(input);
        interpreter.parseString(input);
        updateView();
    }

    /**
     * Sets the language of the interpreter that parses the command.
     * @param language The name of the language.
     */
    public void setLanguage(String language){
    	interpreter.setLanguage(language);
    }

    /**
     * @param fileName
     * @throws InvalidSyntaxException If the syntax of a command is incorrect.
     * @throws InvalidCommandException If an error exists that is related to the command's execution.
     * @throws IOException If there is an error with reading the file.
     * @throws InvalidParametersException If there is an error with passing invalid parameters to a command.
     */
    public void runFile(String fileName) throws InvalidSyntaxException, InvalidCommandException, IOException, InvalidParametersException {
        processCommand(interpreter.readFileToString(fileName));
    }

    /**
     * Updates the view based on the current model.
     */
    @Override
    public void update (Observable o, Object arg) {
        updateView();
        setChanged();
        notifyObservers();
    }

    private void updateView(){
        viewData.updateViewModel(model);
    }
}