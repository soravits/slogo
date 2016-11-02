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
 * The purpose of this class is to receive the data from the view and send it to the controller.Parser to be handled. It will
 * also take the tree that is returned by the interpreter and send it to the interpreter. Essentially, the controller.Controller
 * acts as a gateway to the back-end and facilitates the controller.Parser and Interpreter classes. Currently, it only
 * has an update function, but as the project progresses, it will likely assume more responsibility.
 *
 *
 * @author Soravit
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
    public void setLanguage(String language){
    	interpreter.setLanguage(language);
    }
    
    public void reset(){
    	model.clear();
    	view.updateViewModel(model);
    }
    public void runFile(String fileName) throws InvalidSyntaxException, InvalidCommandException, IOException, InvalidParametersException {
        processCommand(interpreter.readFileToString(fileName));
    }
    private void updateView(){
        view.updateViewModel(model);
    }
    @Override
    public void update (Observable o, Object arg) {
        view.updateViewModel(model);
        setChanged();
        notifyObservers();
        //System.out.println("The controller updated teh model");
    }
   
}