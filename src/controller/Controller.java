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
 * This class is responsible for taking user input from the front-end and executing the command(s) represented
 * by the input in the back-end. The public API provides ways to update the model, update the view, change the language
 * of the interpreter, and execute input that's written in a file.
 *
 * @author Soravit Sophastienphong
 */
public class Controller extends Observable implements Observer{
    private Model model;
    private Interpreter interpreter;
    private ViewData view;
    public Controller(ViewData view){
        this.view = view;
        model = new Model();
        interpreter = new Interpreter(model);
        model.addObserver(this);
    }
    /**
     * This class takes the different data objects/variables packaged into the data object, modifies the controller.Parser and
     * Interpreter as necessary, and sends the data to the controller.Parser.
     * @param input The command inputted by the user
     * @throws Exception 
     */
    public void processCommand(String input) throws InvalidCommandException, InvalidSyntaxException, InvalidParametersException {
    	model.clearConsoleReturn();
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
     *
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
        view.updateViewModel(model);
        setChanged();
        notifyObservers();
    }

    private void updateView(){
        view.updateViewModel(model);
    }
}